package com.cognizant.ormlearn;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner{

    private static final Logger LOGGER=LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args){
        SpringApplication.run(OrmLearnApplication.class,args);
    }

    @Override
    public void run(String... args){
        LOGGER.info("Start");
        List<Employee> employees=employeeService.searchEmployees(50000);
        LOGGER.debug("Employees: {}",employees);
        LOGGER.info("End");
    }
}
