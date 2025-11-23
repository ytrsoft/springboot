package com.ytrsoft.repository;

import com.ytrsoft.entity.Image;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "images")
public interface ImageRepository extends BaseRepository<Image> {}
