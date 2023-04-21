package com.example.restwithpostgres;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Course implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "degreetype")
    private Degreetype degreetype;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coursename")
    private Coursename coursename;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Student.class, mappedBy = "course")
    private List<Course> students;

    public Course() {

    }

    public Course(int courseid, Degreetype degreetype, Coursename coursename) {
        this.courseid = courseid;
        this.degreetype = degreetype;
        this.coursename = coursename;
    }

    public int getcourseid() {
        return courseid;
    }

    public void setcourseid(int courseid) {
        this.courseid = courseid;
    }

    public Degreetype getdegreetype() {
        return degreetype;
    }

    public void setdegreetype(Degreetype degreetype) {
        this.degreetype = degreetype;
    }

    public Coursename getcoursename() {
        return coursename;
    }

    public void setcoursename(Coursename coursename) {
        this.coursename = coursename;
    }

    public List<Course> getStudents() {
        return students;
    }

    public void setStudents(List<Course> students) {
        this.students = students;
    }
}
