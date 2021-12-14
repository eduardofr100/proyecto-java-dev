package com.example.proyectoJavaDev.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "MELTSAN")
@RestController
@RequestMapping("/api/v1/meltsan/employees")
public class EmployeeController {

    @GetMapping("/all")
    public String getEmployees() {
        return "employees";
    }

    @GetMapping("/{employeeId}")
    public Integer getEmployee(@PathVariable("employeeId") Integer employeeId) {
        return employeeId;
    }

}
