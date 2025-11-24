package com.ytrsoft.projection;

import com.ytrsoft.entity.Image;
import com.ytrsoft.entity.Post;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "image", types = { Image.class })
public interface ImageBody extends BaseBody {
    String getSrc();
    Post getPost();
}
