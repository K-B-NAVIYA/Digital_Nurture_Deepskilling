package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy="skillList")
    private List<Employee> employeeList;

    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }

    public List<Employee> getEmployeeList(){ return employeeList; }
    public void setEmployeeList(List<Employee> employeeList){
        this.employeeList=employeeList;
    }
}
