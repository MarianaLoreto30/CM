package com.example.desafio1_cm;

import android.animation.AnimatorInflater;

public class Animal {
    private String name;
    private Integer age;
    private Integer picture;
    private String owner;

    public Animal(String name, Integer picture, Integer age, String owner) {
        this.owner = owner;
        this.name = name;
        this.age = age;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPicture() {
        return picture;
    }

    public void setPicture(Integer picture) {
        this.picture = picture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
