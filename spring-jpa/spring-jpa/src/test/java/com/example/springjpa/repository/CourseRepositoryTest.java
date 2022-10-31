package com.example.springjpa.repository;

import com.example.springjpa.entities.Course;
import com.example.springjpa.entities.CourseMaterial;
import com.example.springjpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void printCourseList(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Couses++++++++++++++++++++++>>>>>>>>>>>");
        System.out.println(courses);
    }
@Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("RahaNahiJata")
                .lastName("Last Name")
                .build();
        Course course = Course
                .builder()
                .title("Python")
                .teacher(teacher)
                .credit("8")
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){

    }
}