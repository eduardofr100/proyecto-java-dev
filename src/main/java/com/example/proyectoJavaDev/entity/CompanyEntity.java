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

    public CompanyEntity() {}

    public CompanyEntity(Integer employeeId, String nameCompany, String businessName, String address) {
        this.employeeId = employeeId;
        this.nameCompany = nameCompany;
        this.businessName = businessName;
        this.address = address;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public String getBusinessName() {
        return businessName;
    }

    public String getAddress() {
        return address;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
