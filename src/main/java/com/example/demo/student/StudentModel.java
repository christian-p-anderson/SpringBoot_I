package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

//This is considered the Student Model

@Entity // for Hibernate
@Table // required to map StudentModel to the DB
public class StudentModel {
    @Id // required to map StudentModel to the DB
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    ) // required to map StudentModel to the DB
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    ) // required to map StudentModel to the DB
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient //it says this field there is no need for you to be a column in our DB | it means we can calculate age first
    private Integer age;

    public StudentModel() {
    }

    public StudentModel(Long id,
                        String name,
                        String email,
                        LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

//We include a constructor without the id, because the DB will create the id for us
    public StudentModel(String name,
                        String email,
                        LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
