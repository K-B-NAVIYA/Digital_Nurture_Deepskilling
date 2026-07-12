package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Attempt;

public interface AttemptService {

    Attempt getAttemptDetails(int attemptId);

}