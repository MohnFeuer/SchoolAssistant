package com.classes.ejnu.service.impl;

import com.classes.ejnu.dataobject.Student;
import com.classes.ejnu.repository.StudentRepository;
import com.classes.ejnu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student findOne(Integer studentId) {
        return repository.findById(studentId).orElse(null);
    }

    @Override
    public List<Student> findAllByMajorId(Integer majorId) {
        return repository.findByMajorId(majorId);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public void delete(Integer studentId) {
        repository.deleteById(studentId);
    }
}
