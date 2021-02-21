package com.classes.ejnu.repository;

import com.classes.ejnu.dataobject.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
