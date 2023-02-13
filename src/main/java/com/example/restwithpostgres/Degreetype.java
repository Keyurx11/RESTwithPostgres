package com.example.restwithpostgres;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Degreetype implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int degreetypeid;
    private String typename;
    private String shortcode;


    @OneToMany(fetch = FetchType.LAZY, targetEntity = Course.class, mappedBy = "degreetype")
    private List<Course> degreetype;

    public Degreetype() {

    }

    public Degreetype(int degreetypeid, String typename, String shortcode) {
        this.degreetypeid = degreetypeid;
        this.typename = typename;
        this.shortcode = shortcode;
    }


    public int getdegreetypeid() {
        return degreetypeid;
    }

    public void setdegreetypeid(int degreetypeid) {
        this.degreetypeid = degreetypeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public List<Course> getDegreetype() {
        return degreetype;
    }

    public void setDegreetype(List<Course> degreetype) {
        this.degreetype = degreetype;
    }
}
