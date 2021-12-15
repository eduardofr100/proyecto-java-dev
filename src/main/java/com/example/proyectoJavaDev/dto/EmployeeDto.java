package com.example.proyectoJavaDev.dto;

import java.io.Serializable;

public class EmployeeDto implements Serializable {
    private Integer employeeId;
    private String name;
    private String lastname;
    private String secondLastname;
    private String job;
    private Integer age;
    private String gender;
    private String status;

    public EmployeeDto () {}

    public EmployeeDto(Integer employeeId, String name, String lastname, String secondLastname,
                       String job, Integer age, String gender, String status) {
        this.employeeId = employeeId;
        this.name = name;
        this.lastname = lastname;
        this.secondLastname = secondLastname;
        this.job = job;
        this.age = age;
        this.gender = gender;
        this.status = status;
    }
    public Integer getEmployeeId() { return employeeId; }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public String getJob() {
        return job;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getStatus() {
        return status;
    }

    public void setEmployeeId(Integer employeeId) { this.employeeId = employeeId; }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
