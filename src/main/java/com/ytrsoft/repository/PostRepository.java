package com.ytrsoft.repository;

import com.ytrsoft.entity.Menu;
import com.ytrsoft.entity.Post;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "menus")
public interface PostRepository extends BaseRepository<Post> {}
