package com.example.springjpa.repository;

import com.example.springjpa.entities.Course;
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


}