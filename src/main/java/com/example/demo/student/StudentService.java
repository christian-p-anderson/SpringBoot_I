package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service //we want to instantiate this in the StudentController class, so we identify it as a spring bean
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentModel> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(StudentModel studentModel) {
        Optional<StudentModel> studentOptional = studentRepository
                .findStudentModelByEmail(studentModel.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }

        studentRepository.save(studentModel);

    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exist"
            );
        }
        studentRepository.deleteById(studentId);

    }

    @Transactional //we don't use any queries below because of @Transactional | using @Transactional puts us
    //in a managed state
    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        StudentModel student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exist"
        ));

        if (name != null &&
            name.length() > 0 &&
            !Objects.equals(student.getName(), name)) {
                student.setName(name);
        }

        if (email != null &&
            email.length() > 0 &&
            !Objects.equals(student.getEmail(), email)) {

            Optional<StudentModel> studentOptional = studentRepository
                    .findStudentModelByEmail(email);

            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
