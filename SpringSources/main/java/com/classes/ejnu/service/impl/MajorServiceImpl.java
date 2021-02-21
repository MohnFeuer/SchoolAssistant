package com.classes.ejnu.service.impl;

import com.classes.ejnu.dataobject.Major;
import com.classes.ejnu.repository.MajorRepository;
import com.classes.ejnu.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorRepository repository;

    @Override
    public Major findOne(Integer majorId) {
        return repository.findById(majorId).orElse(null);
    }

    @Override
    public Page<Major> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Major save(Major major) {
        return repository.save(major);
    }

    @Override
    public void delete(Integer majorId) {
        repository.deleteById(majorId);
    }
}
