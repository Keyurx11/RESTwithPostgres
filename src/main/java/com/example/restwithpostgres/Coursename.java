package com.example.restwithpostgres;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Coursename implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coursenameid;
    private String coursename;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Course.class, mappedBy = "coursename")
    private List<Course> coursenames;

    public Coursename() {

    }

    public Coursename(int coursenameid, String coursename) {
        this.coursenameid = coursenameid;
        this.coursename = coursename;
    }


    public int getcoursenameid() {
        return coursenameid;
    }

    public void setcoursenameid(int coursenameid) {
        this.coursenameid = coursenameid;
    }

    public String getcoursename() {
        return coursename;
    }

    public void setcoursename(String coursename) {
        this.coursename = coursename;
    }

    public List<Course> getCoursenames() {
        return coursenames;
    }

    public void setCoursenames(List<Course> coursenames) {
        this.coursenames = coursenames;
    }
}
