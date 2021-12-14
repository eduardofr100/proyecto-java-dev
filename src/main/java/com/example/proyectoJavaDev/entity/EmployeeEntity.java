package com.example.proyectoJavaDev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleados")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer employeeId = 0;

    @Column(name = "nombre")
    private String name = "";

    @Column(name = "ap_paterno")
    private String firstname = "";

    @Column(name = "ap_materno")
    private String lastname = "";

    @Column(name = "puesto")
    private String job = "";

    @Column(name = "edad")
    private Integer age = 0;

    @Column(name = "genero")
    private String gender = "";

    @Column(name = "estado")
    private String status = "";
}
