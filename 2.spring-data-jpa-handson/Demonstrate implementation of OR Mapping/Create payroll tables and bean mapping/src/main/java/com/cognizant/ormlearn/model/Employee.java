package com.cognizant.ormlearn.model;
import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name="employee")
public class Employee{
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="em_id") private int id;
@Column(name="em_name") private String name;
@Column(name="em_salary") private double salary;
@Column(name="em_permanent") private boolean permanent;
@Temporal(TemporalType.DATE)
@Column(name="em_date_of_birth") private Date dateOfBirth;
public int getId(){return id;}
public void setId(int id){this.id=id;}
public String getName(){return name;}
public void setName(String name){this.name=name;}
public double getSalary(){return salary;}
public void setSalary(double salary){this.salary=salary;}
public boolean isPermanent(){return permanent;}
public void setPermanent(boolean permanent){this.permanent=permanent;}
public Date getDateOfBirth(){return dateOfBirth;}
public void setDateOfBirth(Date d){this.dateOfBirth=d;}
}