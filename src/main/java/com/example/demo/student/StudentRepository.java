package com.example.demo.student;

//this interface is responsible for data access | it's the data access layer

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

}
