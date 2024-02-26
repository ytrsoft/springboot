package com.ytrsoft.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ytrsoft.entity.Address;
import com.ytrsoft.entity.Company;
import com.ytrsoft.entity.Job;
import com.ytrsoft.entity.Project;
import com.ytrsoft.repository.AddressRepository;
import com.ytrsoft.repository.CompanyRepository;
import com.ytrsoft.repository.JobRepository;
import com.ytrsoft.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class DataLoaderService {

    private final ResourceLoader resourceLoader;

    private final CompanyRepository companyRepository;

    private final JobRepository jobRepository;

    private final AddressRepository addressRepository;

    private final ProjectRepository projectRepository;

    @Value("${data.loading.enable}")
    private boolean dataLoadingEnable;

    @Autowired
    public DataLoaderService(
            ResourceLoader resourceLoader,
            CompanyRepository companyRepository,
            JobRepository jobRepository,
            AddressRepository addressRepository,
            ProjectRepository projectRepository
    ) {
        this.resourceLoader = resourceLoader;
        this.companyRepository = companyRepository;
        this.jobRepository = jobRepository;
        this.addressRepository = addressRepository;
        this.projectRepository = projectRepository;
    }

    @PostConstruct
    public void autoExportJSON() throws IOException {
        if (dataLoadingEnable) {
            loadAndSaveEntities("job", new TypeReference<List<Job>>() {}, jobRepository);
            loadAndSaveEntities("company", new TypeReference<List<Company>>() {}, companyRepository);
            loadAndSaveEntities("address", new TypeReference<List<Address>>() {}, addressRepository);
            loadAndSaveEntities("project", new TypeReference<List<Project>>() {}, projectRepository);
        }
    }

    private <T> void loadAndSaveEntities(String name, TypeReference<List<T>> typeRef, PagingAndSortingRepository<T, UUID> repository) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Resource resource = resourceLoader.getResource("classpath:json/" + name + ".json");
        String content = new String(Files.readAllBytes(resource.getFile().toPath()));
        List<T> entities = mapper.readValue(content, typeRef);
        repository.saveAll(entities);
    }

}
