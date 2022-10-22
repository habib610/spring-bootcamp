package com.rhabib.completespring.controller;

import com.rhabib.completespring.entities.Department;
import com.rhabib.completespring.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

//    Get list of departments
    @GetMapping(path = "/departments")
    public List<Department> fetchDepartment(){
        return departmentService.fetchDepartment();
    }

//    Get department by Id
    @GetMapping(path = "/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);
    }


    @PostMapping(path = "/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

}
