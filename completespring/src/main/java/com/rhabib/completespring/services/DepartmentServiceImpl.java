package com.rhabib.completespring.services;

import com.rhabib.completespring.entities.Department;
import com.rhabib.completespring.error.DepartmentNotFoundException;
import com.rhabib.completespring.repositories.DepartmentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {

        Optional<Department> department = departmentRepositories.findById(departmentId);
        if(department.isEmpty()){
            throw new DepartmentNotFoundException("Department not found");
        }
        return  department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepositories.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepositories.findById(departmentId).get();

        if(Objects.nonNull(
                department.getDepartmentName())
                && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(
                department.getDepartmentAddress())
                && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(
                department.getDepartmentCode())
                && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        return depDB;

    }

//    @Override
//    public Department fetchDepartmentByName(String departmentName) {
//        return departmentRepositories.findByDepartmentName(departmentName);
//    }
    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepositories.findByDepartmentNameIgnoreCase(departmentName);
    }




}
