package org.example;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Courses {

    public List<org.example.student> getStudents() {
        return students;
    }

    public void setStudents(List<org.example.student> students) {
        this.students = students;
    }

    @ManyToMany
   private List<student> students;

    // many to one
   /** public org.example.student getStudent() {
        return student;
    }

    public void setStudent(org.example.student student) {
        this.student = student;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    private student student;**/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoursename() {
        return Coursename;
    }

    public void setCoursename(String coursename) {
        Coursename = coursename;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    @Id
    private int id;
    private String Coursename;
    private double price;
    private String reviews;
}
