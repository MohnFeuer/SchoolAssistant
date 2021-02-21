package com.classes.ejnu.repository;

import com.classes.ejnu.dataobject.Contest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestRepository extends JpaRepository<Contest, Integer> {
}
