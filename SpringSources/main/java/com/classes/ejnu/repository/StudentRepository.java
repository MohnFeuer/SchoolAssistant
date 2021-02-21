package com.classes.ejnu.repository;

import com.classes.ejnu.dataobject.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer> {
     List<Student> findByMajorId(Integer majorId);
}
