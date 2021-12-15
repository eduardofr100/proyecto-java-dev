package com.example.proyectoJavaDev.controller;

import com.example.proyectoJavaDev.dto.EmployeeDto;
import com.example.proyectoJavaDev.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "MELTSAN")
@RestController
@RequestMapping("/api/v1/meltsan/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/all")
    public List<EmployeeDto> getEmployees() {
        return employeeService.getAllEmployess();
    }

    @GetMapping("/{employeeId}")
    public EmployeeDto getEmployee(@PathVariable("employeeId") Integer employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

}
