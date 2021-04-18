package com.ytrsoft.service;

import com.ytrsoft.entity.Video;
import com.ytrsoft.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoRepository bookRepository;

    @Autowired
    public VideoServiceImpl(VideoRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public List<Video> saveAll(List<Video> list) {
        List<Video> ret = new ArrayList<>();
        Iterable<Video> books = bookRepository.saveAll(list);
        for (Video book : books) {
            ret.add(book);
        }
        return ret;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Video> list(Pageable page, String name) {
        return bookRepository.findByTitleIgnoreCaseContaining(page, name);
    }

}
