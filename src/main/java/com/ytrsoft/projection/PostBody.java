package com.ytrsoft.projection;

import com.ytrsoft.entity.BaseEntity;
import com.ytrsoft.entity.Image;
import com.ytrsoft.entity.Post;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "post", types = { Post.class })
public interface PostBody extends BaseBody {
    String getTitle();
    String getDescription();
    String getRegion();
    String getAge();
    String getScore();
    String getPrice();
    String getService();
    String getWechat();
    String getPhone();
    String getQq();
    String getMenuId();
    List<Image> getImages();
}
