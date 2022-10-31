package com.example.springjpa.repository;

import com.example.springjpa.entities.Course;
import com.example.springjpa.entities.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void savaCourseMaterialWithCourse(){
        Course course = Course.builder()
                .title("Java OOP")
                .credit("11")
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .course(course)
                .url("www.oracle.com")
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterial(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println("Course Materails_=====================>>>>>>>>>>>>>>>");
        System.out.println(courseMaterialList);
    }
}