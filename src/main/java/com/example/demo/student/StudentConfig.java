package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository studentRepository) {
        return args -> {
            StudentModel miriam = new StudentModel(
                    1L,
                    "Miriam",
                    "miriam.jamal@gmail.com",
                    LocalDate.of(2000, JANUARY, 5),
                    21
            );

            StudentModel alex = new StudentModel(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, JANUARY, 5),
                    21
            );
        };
    };
}
