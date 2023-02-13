package com.example.restwithpostgres;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Student implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private LocalDate dob;
    private String course;

    public Student() {

    }

    public Student(String name, String address, LocalDate dob, String course) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.course = course;
    }

    //    Always do conversion in separate constructor as it help navigate problem
    public Student(String name, String address, String dob, String course) {
        this(name, address, LocalDate.parse(dob), course);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setDob(String dob) {
        setDob(LocalDate.parse(dob));
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}
