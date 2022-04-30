package com.timurholding.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Students {

    @Id // primary key demek
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-increment demek
    private Integer id; // wrapper type -> Integer için default value yoktur direk null gelir

    @Column
    private String name;

    @Column
    private int age; // primitive type -> int için default value 0'dır

    @Column
    private String gender;

    public Students() {
    }

    public Students(Integer id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
