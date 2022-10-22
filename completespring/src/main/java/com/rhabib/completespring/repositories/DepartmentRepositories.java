package com.rhabib.completespring.repositories;

import com.rhabib.completespring.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepositories extends JpaRepository<Department, Long> {
//    Department findByDepartmentName(String departmentName);
    Department findByDepartmentNameIgnoreCase(String departmentName);
}
