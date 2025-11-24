package com.ytrsoft.repository;

import com.ytrsoft.entity.Post;
import com.ytrsoft.projection.PostBody;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "posts", excerptProjection = PostBody.class)
public interface PostRepository extends BaseRepository<Post> {}
