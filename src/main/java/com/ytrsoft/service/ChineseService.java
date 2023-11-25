package com.ytrsoft.service;

import com.ytrsoft.entity.Chinese;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChineseService {
    Page<Chinese> findAll(Chinese search, Pageable pageable);
}
