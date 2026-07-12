package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.repository.AttemptRepository;

@Service
public class AttemptServiceImpl implements AttemptService {

    @Autowired
    private AttemptRepository attemptRepository;

    @Override
    @Transactional
    public Attempt getAttemptDetails(int attemptId) {

        return attemptRepository.getAttemptDetails(attemptId);

    }

}