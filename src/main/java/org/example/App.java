package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// this new change
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
// one to one example - student --> one address
        Address address=new Address();
        address.setId(3);
        address.setDoorno(27);
        address.setCity("Madurai");
        address.setStreet("Church Street");
        address.setPincode("625106");
        // one to many - student ---> many courses
        /**Courses c1=new Courses();
        c1.setId(1);
        c1.setCoursename("Java");
        c1.setPrice(20.0);
        c1.setReviews("This is recommendable course!!");
        c1.setStudent(s1);
        Courses c2=new Courses();
        c2.setId(2);
        c2.setCoursename("Python");
        c2.setPrice(24.0);
        c2.setReviews("This is Good course!!");**/
        //Many to one -- Many courses ---> one student
        /**student s1=new student();
        s1.setName("Surya RajKumar");
        s1.setAge(35);
        s1.setRollno(113);
        Courses c1=new Courses();
         c1.setId(9);
         c1.setCoursename("Java");
         c1.setPrice(20.0);
         c1.setReviews("This is recommendable course!!");
         c1.setStudent(s1);
         Courses c2=new Courses();
         c2.setId(10);
         c2.setCoursename("Python");
         c2.setPrice(24.0);
         c2.setReviews("This is Good course!!");
         c2.setStudent(s1);
      student s2=new student();
       s2.setName("Surya Kumar");
       s2.setAge(20);
       s2.setRollno(20);
      // s1.setAddress(address);
        s2.setCourses(Arrays.asList(c1,c2));**/

        // Many to Many Example
        student s1=new student();
        student s2=new student();
        Courses c1=new Courses();
        c1.setId(4);
        c1.setCoursename("Java");
        c1.setPrice(20.0);
        c1.setReviews("This is recommendable course!!");

        Courses c2=new Courses();
        c2.setId(3);
        c2.setCoursename("Python");
        c2.setPrice(24.0);
        c2.setReviews("This is Good course!!");

        s1=new student();
        s1.setName("Harsh");
        s1.setAge(3);
        s1.setRollno(113);
        s2=new student();
        s2.setName("Yash");
        s2.setAge(4);
        s2.setRollno(20);

        c1.setStudents(Arrays.asList(s1,s2));
        c2.setStudents(Arrays.asList(s1,s2));
        s1.setCourses(Arrays.asList(c1,c2));
        s2.setCourses(Arrays.asList(c1,c2));



        Configuration config=new Configuration();
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate");
        config.setProperty("hibernate.connection.username", "root");
        config.setProperty("hibernate.connection.password", "Alliswell@125");
        config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");

        // Hibernate settings
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        config.setProperty("hibernate.hbm2ddl.auto", "update");
        config.setProperty("hibernate.show_sql", "true");


        // Entity class (you must add your @Entity classes here)
        config.addAnnotatedClass(Address.class);
        config.addAnnotatedClass(student.class);
        config.addAnnotatedClass(Courses.class);

      // Its Heavy objects that manages sessions , produce sessions or connections whenever its needed
        // Its reads the config files , and create db connectionppoling
        SessionFactory sessionFactory=config.buildSessionFactory();
        // Its a light weight object to perform CRUD operation 1 session = 1 db convo
        Session session= sessionFactory.openSession();
        // Its block of operation either all succeed or fails together
        Transaction tx=session.beginTransaction();
        //session.save(address);
        session.save(s1);

       session.save(s2);
        session.save(c1);
        session.save(c2);
        tx.commit();
    }
}
