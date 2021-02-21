package com.classes.ejnu.service;

import com.classes.ejnu.dataobject.Major;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MajorService {

    Major findOne(Integer majorId);

    Page<Major> findAll(Pageable pageable);

    Major save(Major major);

    void delete(Integer majorId);
}
