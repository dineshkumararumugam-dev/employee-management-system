package com.example.employeemanagement.Controller;

import com.example.employeemanagement.Dto.EmployeeDTO;
import com.example.employeemanagement.Service.EmployeeService;
import com.example.employeemanagement.model.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")

public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee addEmployee( @Valid @RequestBody EmployeeDTO dto) {
        return service.addEmployee(dto);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Integer id,
            @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);

}

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return service.getEmployeeById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getEmployeesByDepartment(
            @PathVariable Integer departmentId) {
        return service.getEmployeesByDepartment(departmentId);

    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }

}
