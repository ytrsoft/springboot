package com.ytrsoft.service;

import com.ytrsoft.entity.Video;
import com.ytrsoft.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Video> list(Pageable page, String name) {
        return videoRepository.findByTitleIgnoreCaseContaining(page, name);
    }

}
