package com.ytrsoft.service;

import com.ytrsoft.entity.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VideoService {
    List<Video> saveAll(List<Video> list);
    Page<Video> list(Pageable page, String name);
}
