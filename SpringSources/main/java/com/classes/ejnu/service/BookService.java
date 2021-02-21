package com.classes.ejnu.service;

import com.classes.ejnu.dataobject.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    //查询
    Book findOne(Integer bookId);

    //查询全部
    Page<Book> findAll(Pageable pageable);

    List<Book> findAll();

    //新增与更新
    Book save(Book book);

    //删除
    void delete(Integer bookId);
}
