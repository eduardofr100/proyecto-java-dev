package com.example.proyectoJavaDev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "computadoras")
public class ComputerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no_serie")
    private Integer serialId = 0;

    @Column(name = "modelo")
    private String model = "";

    @Column(name = "marca")
    private String make = "";

    @Column(name = "precio")
    private String price = "";
    
}
