package com.ytrsoft.repository;

import com.ytrsoft.entity.Image;
import com.ytrsoft.projection.ImageBody;
import com.ytrsoft.projection.PostBody;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "images", excerptProjection = ImageBody.class)
public interface ImageRepository extends BaseRepository<Image> {}
