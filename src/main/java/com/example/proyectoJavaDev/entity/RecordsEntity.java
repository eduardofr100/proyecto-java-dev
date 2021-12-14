package com.example.proyectoJavaDev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registros")
public class RecordsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Integer recordId = 0;

    @Column(name = "id_catalogo")
    private Integer catalogId = 0;

    @Column(name = "pk1")
    private String pk1Records = "";

    @Column(name = "pk2")
    private String pk2Records = "";

    @Column(name = "pk3")
    private String pk3Records = "";

    @Column(name = "ds1")
    private String ds1Records = "";

    @Column(name = "ds2")
    private String ds2Records = "";

    @Column(name = "ds3")
    private String ds3Records = "";
    
    @Column(name = "ds4")
    private String ds4Records = "";
}
