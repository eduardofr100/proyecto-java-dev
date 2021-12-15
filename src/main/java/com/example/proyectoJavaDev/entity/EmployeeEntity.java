package com.example.proyectoJavaDev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "empleados")
public class EmployeeEntity implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer employeeId;

    @Column(name = "nombre")
    private String name;

    @Column(name = "ap_paterno")
    private String lastname;

    @Column(name = "ap_materno")
    private String secondLastname;

    @Column(name = "puesto")
    private String job;

    @Column(name = "edad")
    private Integer age;

    @Column(name = "genero")
    private String gender;

    @Column(name = "estado")
    private String status;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Integer employeeId, String name, String lastname, String secondLastname, String job,
                          Integer age, String gender, String status) {
        this.employeeId = employeeId;
        this.name = name;
        this.lastname = lastname;
        this.secondLastname = secondLastname;
        this.job = job;
        this.age = age;
        this.gender = gender;
        this.status = status;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

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

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

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
