package com.example.springjpa.repository;

import com.example.springjpa.entities.Course;
import com.example.springjpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourseList() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("Couses++++++++++++++++++++++>>>>>>>>>>>");
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder().firstName("RahaNahiJata").lastName("Last Name").build();
        Course course = Course.builder().title("Python").teacher(teacher).credit("8").build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();
        long coursesElement = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println("Coursess=======================>>>>>>>>");
        System.out.println("totalPages:" + totalPages);
        System.out.println("coursesElement:" + coursesElement);
        System.out.println("courses:" + courses);

    }

    @Test
    public void findAllBySorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending().and(Sort.by("title").descending()));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("courses:" + courses);

    }
}