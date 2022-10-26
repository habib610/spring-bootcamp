package com.example.springjpa.repository;

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
                .guardianName("Guardian")
                .guardianEmail("guardian@email.com")
                .guardianMobile("039348940").build();

    studentRepository.save(student);
    }
    @Test
    public void getStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList: " + studentList);
    }
}