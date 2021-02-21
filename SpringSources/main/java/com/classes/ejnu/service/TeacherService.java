package com.classes.ejnu.service;

import com.classes.ejnu.dataobject.Teacher;

import java.util.List;

public interface TeacherService {

    //查询
    Teacher findOne(Integer teacherId);

    //按专业查询
    List<Teacher> findAllByMajorId(Integer majorId);

    //查询全部
    List<Teacher> findAll();

    //新增与更新
    Teacher save(Teacher teacher);

    //删除
    void delete(Integer teacherId);
}
