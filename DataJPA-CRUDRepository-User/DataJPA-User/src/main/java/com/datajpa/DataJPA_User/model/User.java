package com.datajpa.DataJPA_User.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name="")
public class User
{
    @Column(name="USER_ID")
    @Id
    private int id;
    @Column(name="USER_NAME")
    private String name;
    @Column(name="USER_GENDER")
    private String gender;
    @Column(name="USER_COUNTRY")
    private String country;
    @Column(name="USER_AGE")
    private int age;

    public User()
    {

    }

    public User(int id, String name, String gender, String country,int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.country = country;
        this.age=age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                '}';
    }
}
