package com.rhabib.completespring.services;

import com.rhabib.completespring.entities.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartment();

    Department fetchDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);
}
