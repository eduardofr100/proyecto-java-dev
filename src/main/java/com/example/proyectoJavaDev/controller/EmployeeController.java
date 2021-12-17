package com.example.proyectoJavaDev.controller;

import com.example.proyectoJavaDev.dto.EmployeeDto;
import com.example.proyectoJavaDev.exception.InternalException;
import com.example.proyectoJavaDev.exception.NotfoundException;
import com.example.proyectoJavaDev.response.EmployeeResponse;
import com.example.proyectoJavaDev.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
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
    public List<EmployeeDto> getEmployees() throws NotfoundException {
        return employeeService.getAllEmployess();
    }

    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDto getEmployee(@PathVariable(value = "employeeId") Integer employeeId) throws NotfoundException{
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/add")
    public Boolean addEmployee(@RequestBody EmployeeDto employeeDto) throws NotfoundException {
        return employeeService.addEmployee(employeeDto);
    }

    @PutMapping("/update")
    public Boolean updateEmployee(@RequestBody EmployeeDto employeeDto,
                                  @RequestParam(value = "employeeId") Integer employeeId) throws NotfoundException {
        return employeeService.updateEmployee(employeeDto, employeeId);
    }

    @GetMapping("/page")
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public EmployeeResponse getAllEmploye(@RequestParam(value = "page") Integer page,
                                          @RequestParam(value = "pageSize") Integer pageSize,
                                          @RequestParam(required = false) String status) throws NotfoundException{
        return employeeService.getEmployePagination(page, pageSize, status);
    }

    @DeleteMapping("/delete")
    public Boolean deleteEmployee(@RequestParam(value = "employeeId") Integer employeeId) throws NotfoundException{
        return employeeService.deleteEmployee(employeeId);
    }

    @GetMapping("/status")
    public List<EmployeeDto> getEmployeeByStatus(@RequestParam(required = false) String status) throws NotfoundException{
        return employeeService.getEmployeByStatus(status);
    }

}
