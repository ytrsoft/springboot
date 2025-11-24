package com.ytrsoft.repository;

import com.ytrsoft.entity.Menu;
import com.ytrsoft.projection.MenuBody;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "menus", excerptProjection = MenuBody.class)
public interface MenuRepository extends BaseRepository<Menu> {}
