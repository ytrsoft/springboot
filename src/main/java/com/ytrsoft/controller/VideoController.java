package com.ytrsoft.controller;

import com.ytrsoft.entity.Video;
import com.ytrsoft.response.ResponseEntity;
import com.ytrsoft.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video")
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @CrossOrigin
    @GetMapping("/list")
    public ResponseEntity<Page<Video>> list(@PageableDefault Pageable page, @RequestParam(defaultValue = "") String title) {
        return ResponseEntity.succeed(videoService.list(page, title));
    }

}
