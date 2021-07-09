package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;

//This is considered the Student Model
`
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
    private Integer age;

    public StudentModel() {
    }

    public StudentModel(Long id,
                        String name,
                        String email,
                        LocalDate dob,
                        Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

//We include a constructor without the id, because the DB will create the id for us
    public StudentModel(String name,
                        String email,
                        LocalDate dob,
                        Integer age) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
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
        return age;
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
