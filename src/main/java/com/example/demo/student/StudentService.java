package com.example.demo.student;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component //we want to instantiate this in the StudentController class, so we identify it as a spring bean
public class StudentService {

    public List<Student> getStudents() {
        return List.of(

                new Student (
                        1L,
                        "Mariam",
                        "mariam.jamal@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        21
                ),
                new Student (
                        2L,
                        "Christian",
                        "ca@gmail.com",
                        LocalDate.of(2000, Month.JUNE, 9),


                        21
                )
        );
    }

}
