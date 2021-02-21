package com.classes.ejnu.service;

import com.classes.ejnu.dataobject.Classes;

import java.util.List;

public interface ClassesService {

    Classes findOne(Integer classesId);

    List<Classes> findAll();

    //根据majorId查询
    List<Classes> findAllByMajorId(Integer majorId);

    //增加/修改
    Classes save(Classes classes);

    //删除
    void delete(Integer classesId);
}
