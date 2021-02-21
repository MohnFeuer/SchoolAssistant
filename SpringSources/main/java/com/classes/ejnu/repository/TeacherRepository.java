package com.classes.ejnu.repository;

import com.classes.ejnu.dataobject.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    List<Teacher> findByMajorId(Integer majorId);
}
