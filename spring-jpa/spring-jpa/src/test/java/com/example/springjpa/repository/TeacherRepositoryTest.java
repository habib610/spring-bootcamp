package com.example.springjpa.repository;

import com.example.springjpa.entities.Course;
import com.example.springjpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
@Test
    public void saveTeacher(){
    Course course = Course.builder()
            .title("Functional Programmig")
            .credit("21")
            .build();

    Teacher teacher = Teacher.builder()
            .firstName("Teacher")
            .lastName("LastName")
//            .courses(List.of(course))
            .build();
    teacherRepository.save(teacher);
}
}