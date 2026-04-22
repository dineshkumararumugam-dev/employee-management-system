package com.example.employeemanagement.Dto;
import lombok.Data;
import jakarta.validation.constraints.*;

@Data

public class EmployeeDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits"
    )
    @NotBlank(message = "Phone number is required")
    private String phone;

    @NotNull(message = "Salary is required")
    private Double salary;

    @NotNull(message = "Department ID is required")
    private Integer departmentId;
}
