package com.example.demo.student;
//this contains all the resources for our API

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    //we want to inject this studentService into public StudentController(StudentService studentService)... constrcutor below
    //we also need to tell that StudentService is a class that has to be instantiated
    //i.e. it has to be a spring bean
    private final StudentService studentService;

    @Autowired //we are saying the studentService above should be autowired to the studentService parameter below | What
    //happens is the the StudentService above will be magically instantiated and then injected into the constructor below
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentModel> getStudents() {
        return this.studentService.getStudents();

    }
}
