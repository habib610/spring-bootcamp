package com.rhabib.completespring.controller;

import com.rhabib.completespring.entities.Department;
import com.rhabib.completespring.services.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    public final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;

    //    Get list of departments
    @GetMapping(path = "/departments")
    public List<Department> fetchDepartment() {
        LOGGER.info("Inside get department");
        return departmentService.fetchDepartment();
    }

    //    Get department by id
    @GetMapping(path = "/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.fetchDepartmentById(departmentId);
    }

    //    Delete department by ID
    @DeleteMapping(path = "/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department with ID " + departmentId + " has been deleted";
    }

    //    Post a department

    @PostMapping(path = "/departments")
    public Department saveDepartment(@Valid  @RequestBody Department department) {
        LOGGER.info("Inside Post department");
        return departmentService.saveDepartment(department);
    }

    //    Update department
    @PutMapping(path = "/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    //    Get Department by name
    @GetMapping(path = "/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
