package com.classes.ejnu.service.impl;

import com.classes.ejnu.dataobject.Exam;
import com.classes.ejnu.repository.ExamRepository;
import com.classes.ejnu.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository repository;

    @Override
    public Exam findOne(Integer examId) {
        return repository.findById(examId).orElse(null);
    }

    @Override
    public Page<Exam> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Exam> findAll() {
        return repository.findAll();
    }

    @Override
    public Exam save(Exam exam) {
        return repository.save(exam);
    }

    @Override
    public void delete(Integer examId) {
        repository.deleteById(examId);
    }
}
