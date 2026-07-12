package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(
      name="employee_skill",
      joinColumns=@JoinColumn(name="es_em_id"),
      inverseJoinColumns=@JoinColumn(name="es_sk_id")
    )
    private List<Skill> skillList;

    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }

    public List<Skill> getSkillList(){ return skillList; }
    public void setSkillList(List<Skill> skillList){
        this.skillList=skillList;
    }
}
