package com.classes.ejnu.service;

import com.classes.ejnu.dataobject.Office;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OfficeService {

    //查询
    Office findOne(String officeId);

    //查询全部
    Page<Office> findAll(Pageable pageable);

    //新增与更新
    Office save(Office office);

    //删除
    void delete(String officeId);
}
