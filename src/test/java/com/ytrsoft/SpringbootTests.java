package com.ytrsoft;

import com.ytrsoft.entity.Book;
import com.ytrsoft.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
class SpringbootTests {

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("西游记", new BigDecimal("59.5")));
        list.add(new Book("红楼梦", new BigDecimal("98.2")));
        list.add(new Book("三国演义", new BigDecimal("77.3")));
        list.add(new Book("水浒传", new BigDecimal("45.6")));
        bookService.saveAll(list).forEach((e) -> {
            log.info(e.toString());
        });
    }

}
