package com.ytrsoft.config;

import com.ytrsoft.entity.Chinese;
import com.ytrsoft.repository.ChineseRepository;
import com.ytrsoft.util.PinyinKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class DataInitializer {
    private final ChineseRepository chineseRepository;

    @Autowired
    public DataInitializer(ChineseRepository chineseRepository) {
        this.chineseRepository = chineseRepository;
    }

    @PostConstruct
    @Transactional
    public void initData() {
        List<Chinese> chineseList = PinyinKit.getAllChineseList();
        chineseRepository.saveAll(chineseList);
    }
}
