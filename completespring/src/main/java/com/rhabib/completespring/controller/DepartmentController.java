package com.rhabib.completespring.controller;

import com.rhabib.completespring.entities.Department;
import com.rhabib.completespring.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(path = "/departments")
    public List<Department> fetchDepartment(){
        return departmentService.fetchDepartment();
    }
    @PostMapping(path = "/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

}
