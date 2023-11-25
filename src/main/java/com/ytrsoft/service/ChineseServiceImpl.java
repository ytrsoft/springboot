package com.ytrsoft.service;

import com.ytrsoft.entity.Chinese;
import com.ytrsoft.repository.ChineseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChineseServiceImpl implements ChineseService {

    private final ChineseRepository chineseRepository;

    @Autowired
    public ChineseServiceImpl(ChineseRepository chineseRepository) {
        this.chineseRepository = chineseRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Chinese> findAll(Chinese search, Pageable pageable) {
        Specification<Chinese> spec = createSpecification(search);
        return chineseRepository.findAll(spec, pageable);
    }

    private Specification<Chinese> createSpecification(Chinese search) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (search.getText() != null) {
                predicates.add(criteriaBuilder.equal(root.get("text"), search.getText()));
            }
            if (search.getPinYin() != null && !search.getPinYin().isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("pinYin"), "%" + search.getPinYin() + "%"));
            }
            if (search.getTone() != null) {
                predicates.add(criteriaBuilder.equal(root.get("tone"), search.getTone()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
