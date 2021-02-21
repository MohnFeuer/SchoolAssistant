package com.classes.ejnu.service.impl;

import com.classes.ejnu.dataobject.Classes;
import com.classes.ejnu.dataobject.Speclass;
import com.classes.ejnu.dataobject.Student;
import com.classes.ejnu.repository.ClassesRepository;
import com.classes.ejnu.repository.SpeclassRepository;
import com.classes.ejnu.repository.StudentRepository;
import com.classes.ejnu.service.SpeclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpeclassServiceImpl implements SpeclassService {

    @Autowired
    private SpeclassRepository repository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassesRepository classesRepository;


    @Override
    public Speclass findOne(Integer speclassId) {
        return repository.findById(speclassId).orElse(null);
    }

    @Override
    public List<Speclass> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Speclass> findAllByClassesId(Integer classesId) {
        return repository.findByClassesId(classesId);
    }

    @Override
    public List<Speclass> findAllByTeacherId(Integer teacherId) {
        return repository.findByTeacherId(teacherId);
    }

    @Override
    public List<Speclass> findAllByStudentId(Integer studentId) {

        //查找学生所属专业的下属课程
        Student student = studentRepository.findById(studentId).orElse(null);
        assert student != null;
        List<Classes> classesList = classesRepository.findByMajorId(student.getMajorId());
        List<Speclass> speclassList = new ArrayList<>();

        //找出所有该专业的具体课程
        for(Classes classes : classesList)
        {
            speclassList.addAll(repository.findByClassesId(classes.getClassesId()));
        }

        //对这些具体课程判断，是否属于这个学生
        List<Speclass> result = new ArrayList<>();
        for(Speclass speclass: speclassList)
        {
            if(speclass.getSpeclassSidl() <= studentId && studentId <= speclass.getSpeclassSidr())
            {
                result.add(speclass);
            }
        }

        return result;
    }

    @Override
    public Speclass save(Speclass speclass) {
        return repository.save(speclass);
    }

    @Override
    public void delete(Integer speclassId) {
        repository.deleteById(speclassId);
    }
}
