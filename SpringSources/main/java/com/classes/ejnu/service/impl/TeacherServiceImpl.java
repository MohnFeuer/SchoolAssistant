package com.classes.ejnu.service.impl;

import com.classes.ejnu.dataobject.Teacher;
import com.classes.ejnu.repository.TeacherRepository;
import com.classes.ejnu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository repository;

    @Override
    public Teacher findOne(Integer teacherId) {
        return repository.findById(teacherId).orElse(null);
    }

    @Override
    public List<Teacher> findAllByMajorId(Integer majorId) {
        return repository.findByMajorId(majorId);
    }

    @Override
    public List<Teacher> findAll() {
        return repository.findAll();
    }

    @Override
    public Teacher save(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public void delete(Integer teacherId) {
        repository.deleteById(teacherId);
    }
}
