package com.example.proyectoJavaDev.service;

import com.example.proyectoJavaDev.dto.EmployeeDto;
import com.example.proyectoJavaDev.dto.common.PageableResponse;
import com.example.proyectoJavaDev.entity.EmployeeEntity;
import com.example.proyectoJavaDev.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeEntity> getAllEmployess() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return employees;
    }


    public PageableResponse<EmployeeDto> getEmployePagination(Integer page, Integer pageSize, String status) {
        return null;
    }
}
