package com.ytrsoft.controller;

import com.ytrsoft.entity.Chinese;
import com.ytrsoft.response.ResponseEntity;
import com.ytrsoft.service.ChineseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chinese")
public class ChineseController {

    private final ChineseService chineseService;

    @Autowired
    public ChineseController(ChineseService chineseService) {
        this.chineseService = chineseService;
    }

    @CrossOrigin
    @GetMapping("/page")
    public ResponseEntity<Page<Chinese>> findAll(Chinese search, Pageable pageable) {
        Page<Chinese> result = chineseService.findAll(search, pageable);
        return ResponseEntity.succeed(result);
    }
}
