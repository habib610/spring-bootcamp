package com.example.springjpa.repository;

import com.example.springjpa.entities.Guardian;
import com.example.springjpa.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("habib@gmail.com")
                .firstName("Habib")
                .lastName("Rahman")
//                .guardianName("Guardian")
//                .guardianEmail("guardian@email.com")
//                .guardianMobile("039348940")
                .build();

    studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("GuardianNew")
                .email("guardian1@gmail.com").mobile("93893830").build();
        Student student = Student.builder()
                .emailId("habib1@gmail.com")
                .firstName("Habib1")
                .lastName("Rahman1").guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList: " + studentList);
    }
}