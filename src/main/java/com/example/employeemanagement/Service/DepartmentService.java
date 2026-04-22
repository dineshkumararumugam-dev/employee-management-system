package com.example.employeemanagement.Service;

import com.example.employeemanagement.Repository.DepartmentRepository;
import com.example.employeemanagement.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    public Department addDepartment(Department department) {
        return repository.save(department);
    }

    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

}
