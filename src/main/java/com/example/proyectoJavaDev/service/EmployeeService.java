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

    public List<EmployeeDto> getAllEmployess() throws NotfoundException {
        List<EmployeeEntity> listEmployeeEntity = employeeRepository.findAll();
        List<String> errors = new ArrayList<>();
        try {
            errors.add("No existen empleados");
            throw new NotfoundException(new CommonErrorResponse(
                    errors,
                    "",
                    "",
                    HttpStatus.NOT_FOUND
            ));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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

    public EmployeeResponse getEmployePagination(Integer page, Integer pageSize, String status) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        Page<EmployeeEntity> pageEmployeeEntity = employeeRepository.findAll(pageRequest);
        PaginationResponse paginationResponse = new PaginationResponse();
        paginationResponse.setSize(pageEmployeeEntity.getSize());
        paginationResponse.setTotalElements(pageEmployeeEntity.getTotalElements());
        paginationResponse.setTotalPages(pageEmployeeEntity.getTotalPages());
        paginationResponse.setCurrentPag(pageEmployeeEntity.getNumber());
        paginationResponse.setLast(pageEmployeeEntity.isLast());
        paginationResponse.setSorted(false);
        List<EmployeeDto> listEmployeeDto = new ArrayList<>();
        for (int i = 0; i < pageEmployeeEntity.getContent().size(); i++)
            listEmployeeDto.add(new EmployeeDto(
                    pageEmployeeEntity.getContent().get(i).getCompanyId(),
                    pageEmployeeEntity.getContent().get(i).getName(),
                    pageEmployeeEntity.getContent().get(i).getLastname(),
                    pageEmployeeEntity.getContent().get(i).getSecondLastname(),
                    pageEmployeeEntity.getContent().get(i).getJob(),
                    pageEmployeeEntity.getContent().get(i).getAge(),
                    pageEmployeeEntity.getContent().get(i).getGender(),
                    pageEmployeeEntity.getContent().get(i).getStatus()
            ));
        return new EmployeeResponse(listEmployeeDto, paginationResponse);
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
