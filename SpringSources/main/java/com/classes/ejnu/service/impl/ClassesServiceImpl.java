package com.classes.ejnu.service.impl;

import com.classes.ejnu.dataobject.Classes;
import com.classes.ejnu.repository.ClassesRepository;
import com.classes.ejnu.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesRepository repository;

    @Override
    public Classes findOne(Integer classesId) {
        return repository.findById(classesId).orElse(null);
    }

    @Override
    public List<Classes> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Classes> findAllByMajorId(Integer majorId) {
        return repository.findByMajorId(majorId);
    }

    @Override
    public Classes save(Classes classes) {
        return repository.save(classes);
    }

    @Override
    public void delete(Integer classesId) {
        repository.deleteById(classesId);
    }
}
