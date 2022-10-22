package com.rhabib.completespring.services;

import com.rhabib.completespring.entities.Department;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

   public List<Department> fetchDepartment();
}
