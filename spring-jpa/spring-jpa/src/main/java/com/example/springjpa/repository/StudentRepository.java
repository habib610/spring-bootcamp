package com.example.springjpa.repository;

import com.example.springjpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //    desc this will exact match the first name
    public List<Student> findStudentByFirstName(String student);

    //    this will match firstname by  regEX
    public List<Student> findStudentByFirstNameContaining(String student);

    //    this will check not null
    public List<Student> findByFirstNameNotNull();

    public List<Student> findByGuardianName(String name);

    //    JPQL jpql queries are created based on className not the table name in Database;
    @Query("select s from Student s where s.studentEmail =?1")
    public List<Student> getStudentByStudentEmail(String emailId);

    //    JPQL
    @Query("select s.firstName from Student s where s.studentEmail =?1")
    public String getStudentFirstNameByStudentEmail(String emailId);

    //    Native SQL query
    @Query(
            value = "SELECT * FROM Student s WHERE s.student_email =?1",
            nativeQuery = true
    )
    public List<Student> getStudentByStudentEmailNative(String emailId);

//Native named params
    @Query(
            value = "SELECT * FROM Student s WHERE s.student_email =:emailId",
            nativeQuery = true
    )
    public List<Student> getStudentByStudentEmailNativeNamedParam(@Param("emailId") String emailId);

//    Update studentFirstName by student email

    @Modifying // for modifyng database like update or delete this annotation will be added
    @Transactional // this should be added in service layer
    @Query(
            value = "update student set first_name = ?1 where student_email=?1",
            nativeQuery = true
    )
    public int updateStudentFirstNameByEmailId(String firstName, String emailId);



}
