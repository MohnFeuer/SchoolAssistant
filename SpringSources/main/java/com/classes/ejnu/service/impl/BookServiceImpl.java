package com.classes.ejnu.service.impl;

import com.classes.ejnu.dataobject.Book;
import com.classes.ejnu.repository.BookRepository;
import com.classes.ejnu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public Book findOne(Integer bookId) {
        return repository.findById(bookId).orElse(null);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book save(Book book) {
        return repository.save(book);
    }

    @Override
    public void delete(Integer bookId) {
        repository.deleteById(bookId);
    }
}
