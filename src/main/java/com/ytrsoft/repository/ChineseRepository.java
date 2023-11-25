package com.ytrsoft.repository;

import com.ytrsoft.entity.Chinese;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ChineseRepository extends BaseRepository<Chinese> {
    Page<Chinese> findAll(Specification<Chinese> spec, Pageable pageable);
}
