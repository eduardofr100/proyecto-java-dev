package com.example.proyectoJavaDev.controller;

import com.example.proyectoJavaDev.dto.EmployeeDto;
import com.example.proyectoJavaDev.dto.common.PageableResponse;
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

    @PostMapping("/add")
    public Boolean addEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);
    }

    @PutMapping("/update")
    public Boolean updateEmployee(@RequestBody EmployeeDto employeeDto,
                                  @RequestParam(value = "employeeId") Integer employeeId) {
        return employeeService.updateEmployee(employeeDto, employeeId);
    }

    @GetMapping()
    public PageableResponse<EmployeeDto> getAllEmploye(@RequestParam(value = "page") Integer page,
                                                    @RequestParam(value = "pageSize") Integer pageSize,
                                                    @RequestParam(value = "status") String status){
        return employeeService.getEmployePagination(page, pageSize, status);
    }

    @DeleteMapping("/delete")
    public Boolean deleteEmployee(@RequestParam(value = "employeeId") Integer employeeId){
        return employeeService.deleteEmployee(employeeId);
    }

}
