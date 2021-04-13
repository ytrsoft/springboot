package com.ytrsoft.controller;

import com.ytrsoft.response.ResponseEntity;
import com.ytrsoft.response.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {

    @GetMapping("/notFound")
    public ResponseEntity<Void> notFound() {
        return ResponseEntity.status(ResponseStatus.NOT_FOUND);
    }

}
