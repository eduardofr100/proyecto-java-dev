package com.example.proyectoJavaDev.service;

import com.example.proyectoJavaDev.dto.EmployeeDto;
import com.example.proyectoJavaDev.dto.common.PageableResponse;
import com.example.proyectoJavaDev.entity.EmployeeEntity;
import com.example.proyectoJavaDev.repository.EmployeeRepository;
import org.springframework.data.domain.PageRequest;
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

    public PageableResponse<EmployeeDto> getEmployePagination(Integer page, Integer pageSize, String status) {
        return null;
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

    public Boolean addEmployee(EmployeeDto employeeDto) {

        employeeRepository.save(new EmployeeEntity(
                employeeDto.getName(),
                employeeDto.getLastname(),
                employeeDto.getSecondLastname(),
                employeeDto.getJob(),
                employeeDto.getAge(),
                employeeDto.getGender(),
                employeeDto.getStatus()
        ));
        return true;
    }

    public Boolean updateEmployee(EmployeeDto employeeDto, Integer id) {
        EmployeeEntity employeeEntity = employeeRepository.findByEmployeeId(id);
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setLastname(employeeDto.getLastname());
        employeeEntity.setSecondLastname(employeeDto.getSecondLastname());
        employeeEntity.setJob(employeeDto.getJob());
        employeeEntity.setAge(employeeDto.getAge());
        employeeEntity.setGender(employeeDto.getGender());
        employeeEntity.setStatus(employeeDto.getStatus());
        employeeRepository.save(employeeEntity);
        return true;
    }

}
