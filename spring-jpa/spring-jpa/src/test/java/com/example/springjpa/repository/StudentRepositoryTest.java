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
//@DataJpaTest // this will flush the data after testing done
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
   @Test
    public void saveStudent(){
        Student student = Student.builder()
                .studentEmail("haib@gmail.com")
                .firstName("habib")
                .lastName("rahman")
//                .guardianEmail("guardian@email.com")
//                .guardianPhone("3030349409")
//                .guardianAddress("bengaloro")
//                .guardianName("guardian")
                .build();
        studentRepository.save(student);
    }
@Test
    public void saveStudentWithGuaridain() {
        Guardian guardian = Guardian.builder()
                .email("guardian3@email.com")
                .name("guardian3")
                .phone("039498u3459").address("mumbai").build();
        Student studentWithGuardian = Student.builder()
                .studentEmail("student3@gmail.com")
                .firstName("rahman")
                .lastName("lastName1")
                .studentEmail("studen3t@email.com")
                .guardian(guardian)
                .build();
    studentRepository.save(studentWithGuardian);
    }

    @Test
    public void findStudentByFirstName(){
       List<Student> student = studentRepository.findStudentByFirstName("rahman");
        System.out.println("student===========================>>>");
        System.out.println(student);
    }

    @Test
    public void findStudentByGuardianName(){
        List<Student> student = studentRepository.findByGuardianName("guardian2");
        System.out.println("student===========================>>>");
        System.out.println(student);
    }
    @Test
    public void findStudentByEmailId(){
        List<Student> student = studentRepository.getStudentByStudentEmail("student@email.com");
        System.out.println("studentEmail===========================>>>");
        System.out.println(student);
    }
    @Test
    public void getStudentFirstNameByEmailId(){
        String student = studentRepository.getStudentFirstNameByStudentEmail("student@email.com");
        System.out.println("studentFirstName===========================>>>");
        System.out.println(student);
    }

    @Test
    public void getStudentByStudentEmailNative(){
        List<Student> student = studentRepository.getStudentByStudentEmailNative("student@email.com");
        System.out.println("studentsByEmailNative===========================>>>");
        System.out.println(student);
    }
    @Test
    public void getListStudent(){
       List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);

    }
}