package com.example.employeemanagement.Controller;

import com.example.employeemanagement.Service.DepartmentService;
import com.example.employeemanagement.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return service.addDepartment(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }

}
