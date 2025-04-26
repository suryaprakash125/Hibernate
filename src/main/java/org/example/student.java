package org.example;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class student {
    @Id
    private int age;
    private String name;

    public List<Courses> getCourses() {
        return courses;
    }
    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    @ManyToMany(mappedBy = "students")
    private List<Courses> courses;
    // one to many
   /** public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
  private List<Courses> courses;**/

// one to one
  /**  public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @OneToOne(cascade = CascadeType.ALL)
    private Address address;**/

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
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

    private int rollno;
}
