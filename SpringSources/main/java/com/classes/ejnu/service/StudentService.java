package com.classes.ejnu.service;

import com.classes.ejnu.dataobject.Student;

import java.util.List;

public interface StudentService {

    //查询
    Student findOne(Integer studentId);

    //按专业查询
    List<Student> findAllByMajorId(Integer majorId);

    //查询全部
    List<Student> findAll();

    //新增与更新
    Student save(Student student);

    //删除
    void delete(Integer studentId);
}
