package com.example.proyectoJavaDev.dto;

import java.io.Serializable;

public class ComputerDto implements Serializable {
    private String model;
    private String make;
    private String price;

    public ComputerDto() {}

    public ComputerDto(String model, String make, String price) {
        this.model = model;
        this.make = make;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public String getPrice() {
        return price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
