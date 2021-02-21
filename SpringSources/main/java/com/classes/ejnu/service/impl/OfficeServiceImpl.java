package com.classes.ejnu.service.impl;

import com.classes.ejnu.dataobject.Office;
import com.classes.ejnu.repository.OfficeRepository;
import com.classes.ejnu.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    public OfficeServiceImpl() {
        super();
    }

    @Autowired
    private OfficeRepository repository;

    @Override
    public Office findOne(String officeId) {
        return repository.findById(officeId).orElse(null);
    }

    @Override
    public Page<Office> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Office save(Office office) {
        return repository.save(office);
    }

    @Override
    public void delete(String officeId) {
        repository.deleteById(officeId);
    }
}
