package com.ytrsoft.service;

import com.ytrsoft.entity.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VideoService {
    Page<Video> list(Pageable page, String name);
}
