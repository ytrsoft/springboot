package com.ytrsoft.service;

import com.ytrsoft.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<Book> saveAll(List<Book> list);
    Page<Book> list(Pageable page, String name);
}
