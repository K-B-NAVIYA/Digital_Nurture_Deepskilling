package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
@Entity
public class Employee{
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;

@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
@JoinColumn(name="em_dp_id")
private Department department;

public int getId(){return id;}
public void setId(int id){this.id=id;}
public String getName(){return name;}
public void setName(String name){this.name=name;}
public Department getDepartment(){return department;}
public void setDepartment(Department d){this.department=d;}
}