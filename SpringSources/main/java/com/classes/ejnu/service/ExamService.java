package com.classes.ejnu.service;

import com.classes.ejnu.dataobject.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExamService {


    //查询
    Exam findOne(Integer examId);

    //查询全部
    Page<Exam> findAll(Pageable pageable);

    List<Exam> findAll();

    //新增与更新
    Exam save(Exam exam);

    //删除
    void delete(Integer examId);

}
