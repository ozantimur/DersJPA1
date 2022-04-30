package com.timurholding.model;

public class Ogrenci {

    private Integer id; // wrapper type -> Integer için default value yoktur direk null gelir.
    private String name;
    private int age; // primitive type -> int için default value 0'dır.
    private String gender;



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

    public void genderDegeriAta(String yeniGender) {
        gender = yeniGender;
    }
}
