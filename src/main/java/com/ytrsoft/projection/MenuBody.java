package com.ytrsoft.projection;

import com.ytrsoft.entity.Menu;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "menu", types = { Menu.class })
public interface MenuBody extends BaseBody {
    String getName();
}
