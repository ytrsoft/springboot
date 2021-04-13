package com.ytrsoft.service;

import com.ytrsoft.entity.Book;
import com.ytrsoft.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public List<Book> saveAll(List<Book> list) {
        List<Book> ret = new ArrayList<>();
        Iterable<Book> books = bookRepository.saveAll(list);
        for (Book book : books) {
            ret.add(book);
        }
        return ret;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Book> list(Pageable page, String name) {
        return bookRepository.findByNameIgnoreCaseContaining(page, name);
    }

}
