package com.classes.ejnu.service.impl;

import com.classes.ejnu.dataobject.Contest;
import com.classes.ejnu.repository.ContestRepository;
import com.classes.ejnu.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContestServiceImpl implements ContestService {

    @Autowired
    private ContestRepository repository;

    @Override
    public Contest findOne(Integer contestId) {
        return repository.findById(contestId).orElse(null);
    }

    @Override
    public Page<Contest> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Contest> findAll() {
        return repository.findAll();
    }

    @Override
    public Contest save(Contest contest) {
        return repository.save(contest);
    }

    @Override
    public void delete(Integer contestId) {
        repository.deleteById(contestId);
    }
}
