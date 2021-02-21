package com.classes.ejnu.repository;

import com.classes.ejnu.dataobject.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassesRepository extends JpaRepository<Classes, Integer> {
    List<Classes> findByMajorId(Integer majorId);
}
