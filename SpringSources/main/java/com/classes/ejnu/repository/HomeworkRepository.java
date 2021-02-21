package com.classes.ejnu.repository;

import com.classes.ejnu.dataobject.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeworkRepository extends JpaRepository<Homework, Integer> {
    List<Homework> findBySpeclassId(Integer speclassId);
}
