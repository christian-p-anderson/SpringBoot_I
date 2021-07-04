package com.example.demo.student;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component //we want to instantiate this in the StudentController class, so we identify it as a spring bean
public class StudentService {

    public List<StudentModel> getStudents() {
        return List.of(

                new StudentModel(
                        1L,
                        "Mariam",
                        "mariam.jamal@gmail.com",
                        LocalDate.of(2000, Month.JANUARY, 5),
                        21
                ),
                new StudentModel(
                        2L,
                        "Christian",
                        "ca@gmail.com",
                        LocalDate.of(2000, Month.JUNE, 9),
                        21
                )
        );
    }

}
