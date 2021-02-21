package com.classes.ejnu.service;

import com.classes.ejnu.dataobject.Contest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContestService {


    //查询
    Contest findOne(Integer contestId);

    //查询全部
    Page<Contest> findAll(Pageable pageable);

    List<Contest> findAll();

    //新增与更新
    Contest save(Contest contest);

    //删除
    void delete(Integer contestId);
}
