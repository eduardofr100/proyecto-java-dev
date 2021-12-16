package com.example.proyectoJavaDev.service;

import com.example.proyectoJavaDev.common.CommonErrorResponse;
import com.example.proyectoJavaDev.dto.EmployeeDto;
import com.example.proyectoJavaDev.entity.EmployeeEntity;
import com.example.proyectoJavaDev.exception.NotfoundException;
import com.example.proyectoJavaDev.repository.EmployeeRepository;
import com.example.proyectoJavaDev.response.EmployeeResponse;
import com.example.proyectoJavaDev.response.PaginationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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
                    listEmployeeEntity.get(i).getCompanyId(),
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

    public EmployeeResponse getEmployePagination(Integer page, Integer pageSize, String status) throws NotfoundException {
        PageRequest pageable = PageRequest.of(page - 1, pageSize);
        Page<EmployeeEntity> data = employeeRepository.findAll(pageable);
        List<String> errors = new ArrayList<>();
        if (data.isEmpty()) {
            errors.add("No existen datos de empleados con los par\u00E1metros proporcionados");
            CommonErrorResponse commonErrorResponse = new CommonErrorResponse(
                    errors,
                    "Deben de proporcionar datos correctos",
                    "Consulta de empleados",
                    HttpStatus.NOT_FOUND
            );
            throw new NotfoundException(commonErrorResponse);
        }
        if (status == null) {
            employeeRepository.findAll(pageable);
        } else {
            employeeRepository.findByStatus(status, pageable);
        }
        PaginationResponse pageUser = new PaginationResponse();
        pageUser.setSize(data.getSize());
        pageUser.setTotalElements(data.getTotalElements());
        pageUser.setTotalPages(data.getTotalPages());
        pageUser.setCurrentPag(data.getNumber());
        pageUser.setLast(data.isLast());
        pageUser.setSorted(false);
        List<EmployeeDto> data1 = new ArrayList<>();
        for (int i = 0; i < data.getContent().size(); i++) {
            data1.add(new EmployeeDto(
                    data.getContent().get(i).getCompanyId(),
                    data.getContent().get(i).getName(),
                    data.getContent().get(i).getLastname(),
                    data.getContent().get(i).getSecondLastname(),
                    data.getContent().get(i).getJob(),
                    data.getContent().get(i).getAge(),
                    data.getContent().get(i).getGender(),
                    data.getContent().get(i).getStatus()
            ));
        }
        EmployeeResponse employeeResponse = new EmployeeResponse(data1, pageUser);
        return employeeResponse;
    }

    public EmployeeDto getEmployeeById(Integer id) {
        EmployeeEntity employeeEntity = employeeRepository.findByEmployeeId(id);
        return new EmployeeDto(
                employeeEntity.getCompanyId(),
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
                employeeDto.getEmployeeId(),
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

    public Boolean deleteEmployee(Integer id) {
        EmployeeEntity employeeEntity = employeeRepository.findByEmployeeId(id);
        employeeRepository.delete(employeeEntity);
        return true;
    }

    public List<EmployeeDto> getEmployeByStatus(String status) {
        List<EmployeeEntity> listEmployeeEntity = employeeRepository.findByStatus(status);
        List<EmployeeDto> listEmployeesDto = new ArrayList<>();
        for (int i = 0; i < listEmployeeEntity.size(); i++) {
            listEmployeesDto.add(new EmployeeDto(
                    listEmployeeEntity.get(i).getCompanyId(),
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
}
