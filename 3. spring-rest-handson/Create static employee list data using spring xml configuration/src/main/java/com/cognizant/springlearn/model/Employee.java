package com.cognizant.springlearn.model;
import java.util.List;
public class Employee{
 private int id; private String name; private double salary; private boolean permanent;
 private Department department; private List<Skill> skillList;
 public Employee(){}
 public Employee(int id,String name,double salary,boolean permanent){
  this.id=id;this.name=name;this.salary=salary;this.permanent=permanent;}
 public int getId(){return id;} public void setId(int id){this.id=id;}
 public String getName(){return name;} public void setName(String name){this.name=name;}
 public double getSalary(){return salary;} public void setSalary(double salary){this.salary=salary;}
 public boolean isPermanent(){return permanent;} public void setPermanent(boolean p){this.permanent=p;}
 public Department getDepartment(){return department;} public void setDepartment(Department d){this.department=d;}
 public List<Skill> getSkillList(){return skillList;} public void setSkillList(List<Skill> s){this.skillList=s;}
}