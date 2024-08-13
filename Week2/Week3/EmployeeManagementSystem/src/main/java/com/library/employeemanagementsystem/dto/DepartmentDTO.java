package com.library.employeemanagementsystem.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DepartmentDTO {
    private long id;
    private String name;
    private int employeeCount;
    private List<EmployeeDTO> employees;
 // Constructor
    public DepartmentDTO(long id, String name, int employeeCount, List<EmployeeDTO> employees) {
        this.id = id;
        this.name = name;
        this.employeeCount = employeeCount;
        this.employees = employees;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
