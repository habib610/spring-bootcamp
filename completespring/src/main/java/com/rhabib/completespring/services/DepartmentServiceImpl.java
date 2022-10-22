package com.rhabib.completespring.services;

import com.rhabib.completespring.entities.Department;
import com.rhabib.completespring.repositories.DepartmentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepositories departmentRepositories;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepositories.save(department);
    }

    @Override
    public List<Department> fetchDepartment() {
        return departmentRepositories.findAll();
    }


}
