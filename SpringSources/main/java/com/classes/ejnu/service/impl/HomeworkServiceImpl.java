package com.classes.ejnu.service.impl;

import com.classes.ejnu.dataobject.Homework;
import com.classes.ejnu.repository.HomeworkRepository;
import com.classes.ejnu.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    private HomeworkRepository repository;

    @Override
    public Homework findOne(Integer homeworkId) {
        return repository.findById(homeworkId).orElse(null);
    }

    @Override
    public List<Homework> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Homework> findAllBySpeclassId(Integer speclassId) {
        return repository.findBySpeclassId(speclassId);
    }

    @Override
    public Homework save(Homework homework) {
        return repository.save(homework);
    }

    @Override
    public void delete(Integer homeworkId) {
        repository.deleteById(homeworkId);
    }
}
