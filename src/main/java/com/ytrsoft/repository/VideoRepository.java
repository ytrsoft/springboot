package com.ytrsoft.repository;

import com.ytrsoft.entity.Video;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VideoRepository extends BaseRepository<Video> {
    Page<Video> findByTitleIgnoreCaseContainingOrderByDateDesc(Pageable page, String name);
}
