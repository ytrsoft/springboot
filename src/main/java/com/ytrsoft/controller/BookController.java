package com.ytrsoft.controller;

import com.ytrsoft.entity.Book;
import com.ytrsoft.response.ResponseEntity;
import com.ytrsoft.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Book>> list(@PageableDefault Pageable page, @RequestParam(defaultValue = "") String name) {
        return ResponseEntity.succeed(bookService.list(page, name));
    }

}
