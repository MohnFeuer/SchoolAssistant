package com.classes.ejnu.repository;

import com.classes.ejnu.dataobject.Speclass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeclassRepository extends JpaRepository<Speclass, Integer> {

    List<Speclass> findByClassesId(Integer classesId);

    List<Speclass> findByTeacherId(Integer classesId);
}
