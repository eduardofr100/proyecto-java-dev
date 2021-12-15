package com.example.proyectoJavaDev.dto;

import java.io.Serializable;

public class CompanyDto implements Serializable {
    private String nameCompany;
    private String businessName;
    private String address;

    public CompanyDto() {}

    public CompanyDto(String nameCompany, String businessName, String address) {
        this.nameCompany = nameCompany;
        this.businessName = businessName;
        this.address = address;
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
