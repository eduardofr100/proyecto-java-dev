package com.example.proyectoJavaDev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresas")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer employeeId = 0;

    @Column(name = "nombre_empresa")
    private String nameCompany = "";

    @Column(name = "razon_social")
    private String businessName = "";

    @Column(name = "direccion")
    private String address = "";
}
