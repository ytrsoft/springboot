package com.ytrsoft.repository;

import com.ytrsoft.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookRepository extends BaseRepository<Book> {
    Page<Book> findByNameIgnoreCaseContaining(Pageable page, String name);
}
