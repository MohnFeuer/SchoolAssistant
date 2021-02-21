package com.classes.ejnu.service;

import com.classes.ejnu.dataobject.Speclass;

import java.util.List;

public interface SpeclassService {

    Speclass findOne(Integer speclassId);

    List<Speclass> findAll();

    //根据classesId查询
    List<Speclass> findAllByClassesId(Integer classesId);

    //根据teacherId查询
    List<Speclass> findAllByTeacherId(Integer teacherId);

    //根据studentId查询所有属于该学生的具体课程
    List<Speclass> findAllByStudentId(Integer studentId);

    //增加/修改
    Speclass save(Speclass speclass);

    //删除
    void delete(Integer speclassId);
    
}
