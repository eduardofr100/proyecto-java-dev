package com.example.proyectoJavaDev.service;

import com.example.proyectoJavaDev.common.CommonErrorResponse;
import com.example.proyectoJavaDev.dto.EmployeeDto;
import com.example.proyectoJavaDev.entity.EmployeeEntity;
import com.example.proyectoJavaDev.exception.BadRequestException;
import com.example.proyectoJavaDev.exception.NotfoundException;
import com.example.proyectoJavaDev.repository.CompanyRepository;
import com.example.proyectoJavaDev.repository.EmployeeRepository;
import com.example.proyectoJavaDev.response.EmployeeResponse;
import com.example.proyectoJavaDev.response.PaginationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    public List<EmployeeDto> getAllEmployess() throws NotfoundException {
        List<EmployeeEntity> listEmployeeEntity = employeeRepository.findAll();
        List<String> errors = new ArrayList<>();
        if (listEmployeeEntity.isEmpty()) {
            errors.add("No existen datos de empleados");
            throw new NotfoundException(new CommonErrorResponse(
                    errors,
                    "No hay registros en la base de datos",
                    "Consulta de todos los empleados",
                    HttpStatus.NOT_FOUND
            ));
        }
        errors.add("No existen empleados");
        List<EmployeeDto> listEmployeesDto = new ArrayList<>();
        for (EmployeeEntity employeeEntity : listEmployeeEntity) {
            listEmployeesDto.add(new EmployeeDto(
                    employeeEntity.getCompanyId(),
                    employeeEntity.getName(),
                    employeeEntity.getLastname(),
                    employeeEntity.getSecondLastname(),
                    employeeEntity.getJob(),
                    employeeEntity.getAge(),
                    employeeEntity.getGender(),
                    employeeEntity.getStatus()
            ));
        }
        return listEmployeesDto;
    }

    public EmployeeResponse getEmployePagination(Integer page, Integer pageSize, String status) throws NotfoundException, BadRequestException {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        Page<EmployeeEntity> pageEmployeeEntity = employeeRepository.findAll(pageRequest);
        List<String> errors = new ArrayList<>();
        if (pageEmployeeEntity.isEmpty()) {
            errors.add("No existen datos de empleados con los par\u00E1metros proporcionados");
            CommonErrorResponse commonErrorResponse = new CommonErrorResponse(
                    errors,
                    "Deben de proporcionar datos correctos",
                    "Consulta de empleados",
                    HttpStatus.NOT_FOUND
            );
            throw new NotfoundException(commonErrorResponse);
        }
        if (status != null) {
            pageEmployeeEntity = employeeRepository.findByStatus(status, pageRequest);
        } else if (pageEmployeeEntity.isEmpty()) {
            errors.add("El par\u00E1metro de estado debe ser A o I");
            throw new BadRequestException(new CommonErrorResponse(
                    errors,
                    "Deben de proporcionar datos correctos",
                    "Consulta de paginación de empleados",
                    HttpStatus.NOT_FOUND
            ));
        }
        PaginationResponse paginationResponse = new PaginationResponse();
        paginationResponse.setSize(pageEmployeeEntity.getSize());
        paginationResponse.setTotalElements(pageEmployeeEntity.getTotalElements());
        paginationResponse.setTotalPages(pageEmployeeEntity.getTotalPages());
        paginationResponse.setCurrentPag(pageEmployeeEntity.getNumber());
        paginationResponse.setLast(pageEmployeeEntity.isLast());
        paginationResponse.setSorted(false);
        List<EmployeeDto> listEmployeesDto = new ArrayList<>();
        for (int i = 0; i < pageEmployeeEntity.getContent().size(); i++)
            listEmployeesDto.add(new EmployeeDto(
                    pageEmployeeEntity.getContent().get(i).getCompanyId(),
                    pageEmployeeEntity.getContent().get(i).getName(),
                    pageEmployeeEntity.getContent().get(i).getLastname(),
                    pageEmployeeEntity.getContent().get(i).getSecondLastname(),
                    pageEmployeeEntity.getContent().get(i).getJob(),
                    pageEmployeeEntity.getContent().get(i).getAge(),
                    pageEmployeeEntity.getContent().get(i).getGender(),
                    pageEmployeeEntity.getContent().get(i).getStatus()
            ));
        return new EmployeeResponse(listEmployeesDto, paginationResponse);
    }

    public EmployeeDto getEmployeeById(Integer id) throws NotfoundException{
        var employeeEntity = employeeRepository.findById(id);
        if (employeeEntity.isPresent()) {
            return new EmployeeDto(
                    employeeEntity.get().getCompanyId(),
                    employeeEntity.get().getName(),
                    employeeEntity.get().getLastname(),
                    employeeEntity.get().getSecondLastname(),
                    employeeEntity.get().getJob(),
                    employeeEntity.get().getAge(),
                    employeeEntity.get().getGender(),
                    employeeEntity.get().getStatus()
            );
        }
        List<String> errors = new ArrayList<>();
        errors.add("No existe el empleado con el registro Id: " + id.toString());
        CommonErrorResponse commonErrorResponse = new CommonErrorResponse(
                errors,
                "Error en la consulta",
                "Consulta de empleados",
                HttpStatus.NOT_FOUND
        );
        throw new NotfoundException(commonErrorResponse);
    }

    public Boolean addEmployee(EmployeeDto employeeDto) throws NotfoundException {
        var company = companyRepository.findById(employeeDto.getCompanyId());
        if (company.isPresent()){
            employeeRepository.save(new EmployeeEntity(
                    employeeDto.getCompanyId(),
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
        List<String> errors = new ArrayList<>();
        errors.add("No existe registro de la empresa con el Id: " + employeeDto.getCompanyId().toString());
        CommonErrorResponse commonErrorResponse = new CommonErrorResponse(
                errors,
                "Error en la agregar empleados",
                "Agregar nuevos empleados",
                HttpStatus.NOT_FOUND
        );
        throw new NotfoundException(commonErrorResponse);
    }

    public Boolean updateEmployee(EmployeeDto employeeDto, Integer id) throws NotfoundException {
        var employeeEntity = employeeRepository.findByEmployeeId(id);
        if (employeeEntity.isPresent()) {
            employeeEntity.get().setCompanyId(employeeDto.getCompanyId());
            employeeEntity.get().setName(employeeDto.getName());
            employeeEntity.get().setLastname(employeeDto.getLastname());
            employeeEntity.get().setSecondLastname(employeeDto.getSecondLastname());
            employeeEntity.get().setJob(employeeDto.getJob());
            employeeEntity.get().setAge(employeeDto.getAge());
            employeeEntity.get().setGender(employeeDto.getGender());
            employeeEntity.get().setStatus(employeeDto.getStatus());
            employeeRepository.save(employeeEntity.get());
            return true;
        }
        List<String> errors = new ArrayList<>();
        errors.add("No existe registro del empleado con el Id: " + id.toString());
        CommonErrorResponse commonErrorResponse = new CommonErrorResponse(
                errors,
                "Error al modificar el empleado",
                "Modificacion de datos de empleados",
                HttpStatus.NOT_FOUND
        );
        throw new NotfoundException(commonErrorResponse);
    }

    public Boolean deleteEmployee(Integer id) throws NotfoundException {
        var employeeEntity = employeeRepository.findById(id);
        if (employeeEntity.isPresent()) {
            employeeRepository.delete(employeeEntity.get());
            return true;
        }
        List<String> errors = new ArrayList<>();
        errors.add("No existe el empleado con el registro Id: " +id.toString());
        CommonErrorResponse commonErrorResponse = new CommonErrorResponse(
                errors,
                "Error en la consulta",
                "Eliminar de empleados",
                HttpStatus.NOT_FOUND
        );
        throw new NotfoundException(commonErrorResponse);
    }

    public List<EmployeeDto> getEmployeByStatus(String status) throws NotfoundException {
        List<EmployeeEntity> listEmployeeEntity = employeeRepository.findByStatus(status);
        List<EmployeeDto> listEmployeesDto = new ArrayList<>();
        if (!listEmployeeEntity.isEmpty()) {
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
        List<String> errors = new ArrayList<>();
        errors.add("No existe el empleado con ese estatus");
        CommonErrorResponse commonErrorResponse = new CommonErrorResponse(
                errors,
                "Error en consulta de estatus",
                "Consulta de estatus de empleados",
                HttpStatus.NOT_FOUND
        );
        throw new NotfoundException(commonErrorResponse);
    }
}
