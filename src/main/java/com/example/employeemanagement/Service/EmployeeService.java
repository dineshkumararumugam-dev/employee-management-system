package com.example.employeemanagement.Service;

import com.example.employeemanagement.Dto.EmployeeDTO;
import com.example.employeemanagement.Repository.DepartmentRepository;
import com.example.employeemanagement.Repository.EmployeeRepository;
import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employeemanagement.Exception.ResourceNotFoundException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee addEmployee(EmployeeDTO dto) {

        Department department = departmentRepository

                .findById(dto.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department not found"));

        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setSalary(dto.getSalary());
        employee.setDepartment(department);

        return employeeRepository.save(employee);
    }


    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found"));
    }


    public Employee updateEmployee(Integer id, Employee employee) {

        // Step 1: Find existing employee
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found"));

        // Step 2: Update fields
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setSalary(employee.getSalary());

        // Step 3: Update department
        if (employee.getDepartment() != null) {

            Integer deptId = employee.getDepartment().getId();

            Department department = departmentRepository
                    .findById(deptId)
                    .orElseThrow(() ->
                            new ResourceNotFoundException(
                                    "Department not found"));

            existingEmployee.setDepartment(department);
        }

        // Step 4: Save
        return employeeRepository.save(existingEmployee);
    }

    public List<Employee> getEmployeesByDepartment(Integer departmentId) {

        return employeeRepository.findByDepartmentId(departmentId);

    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

}
