package com.cognizant.ormlearn.repository;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.cognizant.ormlearn.model.Employee;

@Repository
public class EmployeeCriteriaRepositoryImpl implements EmployeeCriteriaRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> searchEmployees(double minSalary){
        CriteriaBuilder cb=entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq=cb.createQuery(Employee.class);
        Root<Employee> root=cq.from(Employee.class);
        cq.select(root).where(cb.greaterThan(root.get("salary"),minSalary));
        return entityManager.createQuery(cq).getResultList();
    }
}
