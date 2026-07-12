package com.cognizant.ormlearn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeCriteriaRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeCriteriaRepository repository;

    @Override
    public List<Employee> searchEmployees(double minSalary){
        return repository.searchEmployees(minSalary);
    }
}
