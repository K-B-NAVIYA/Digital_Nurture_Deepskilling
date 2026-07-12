package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.service.AttemptService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private AttemptService attemptService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @PostConstruct
    public void testFetchQuizAttempt() {

        LOGGER.info("Start");

        Attempt attempt = attemptService.getAttemptDetails(1);

        LOGGER.debug("Attempt : {}", attempt);

        LOGGER.info("End");
    }
}