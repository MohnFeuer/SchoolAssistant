package com.classes.ejnu.repository;

import com.classes.ejnu.dataobject.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
