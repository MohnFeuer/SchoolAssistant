package com.classes.ejnu.service;

import com.classes.ejnu.dataobject.Homework;
import com.classes.ejnu.dataobject.Homework;

import java.util.List;

public interface HomeworkService {

    Homework findOne(Integer homeworkId);

    List<Homework> findAll();

    //根据具体课程speclassId查询
    List<Homework> findAllBySpeclassId(Integer speclassId);

    //增加/修改
    Homework save(Homework homework);

    //删除
    void delete(Integer homeworkId);

}
