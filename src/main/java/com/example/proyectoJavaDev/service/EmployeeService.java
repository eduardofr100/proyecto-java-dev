package com.example.proyectoJavaDev.service;

import com.example.proyectoJavaDev.dto.EmployeeDto;
import com.example.proyectoJavaDev.entity.EmployeeEntity;
import com.example.proyectoJavaDev.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> getAllEmployess() {
        List<EmployeeEntity> listEmployeeEntity = employeeRepository.findAll();
        List<EmployeeDto> listEmployeesDto = new ArrayList<>();
        for (int i = 0; i < listEmployeeEntity.size(); i++) {
            listEmployeesDto.add(new EmployeeDto(
                    listEmployeeEntity.get(i).getName(),
                    listEmployeeEntity.get(i).getLastname(),
                    listEmployeeEntity.get(i).getSecondLastname(),
                    listEmployeeEntity.get(i).getJob(),
                    listEmployeeEntity.get(i).getAge(),
                    listEmployeeEntity.get(i).getGender(),
                    listEmployeeEntity.get(i).getStatus()
            ));
        }
        return listEmployeesDto;
    }

    public EmployeeDto getEmployeeById(Integer id) {
        EmployeeEntity employeeEntity = employeeRepository.findByEmployeeId(id);
        return new EmployeeDto(
                employeeEntity.getName(),
                employeeEntity.getLastname(),
                employeeEntity.getSecondLastname(),
                employeeEntity.getJob(),
                employeeEntity.getAge(),
                employeeEntity.getGender(),
                employeeEntity.getStatus()
        );
    }

}
