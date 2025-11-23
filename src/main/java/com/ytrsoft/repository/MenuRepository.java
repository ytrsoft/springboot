package com.ytrsoft.repository;

import com.ytrsoft.entity.Menu;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "menus")
public interface MenuRepository extends BaseRepository<Menu> {}
