package com.classes.ejnu.repository;

import com.classes.ejnu.dataobject.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, String> {
}
