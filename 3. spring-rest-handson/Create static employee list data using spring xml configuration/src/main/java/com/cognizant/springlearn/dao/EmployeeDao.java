package com.cognizant.springlearn.dao;
import java.util.*;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import com.cognizant.springlearn.model.Employee;
@Repository
public class EmployeeDao{
 public static List<Employee> EMPLOYEE_LIST;
 @SuppressWarnings("unchecked")
 public EmployeeDao(){
  ApplicationContext ctx=new ClassPathXmlApplicationContext("employee.xml");
  EMPLOYEE_LIST=(List<Employee>)ctx.getBean("employeeList");
 }
 public List<Employee> getAllEmployees(){ return EMPLOYEE_LIST; }
}