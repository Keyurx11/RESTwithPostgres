package com.example.restwithpostgres;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentid;
    private String name;
    private String address;
    private LocalDate dob;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course")

    private Course course;

    public Student() {

    }

    public Student(String name, String address, LocalDate dob, Course course) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.course = course;
    }

    //    Always do conversion in separate constructor as it help navigate problem
    public Student(String name, String address, String dob, Course course) {
        this(name, address, LocalDate.parse(dob), course);
    }

    public int getId() {
        return studentid;
    }

    public void setId(int studentid) {
        this.studentid = studentid;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}

