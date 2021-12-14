package com.example.proyectoJavaDev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "columnas")
public class ColumnsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_columna")
    private Integer columnId = 0;

    @Column(name = "id_catalogo")
    private Integer catalogId = 0;

    @Column(name = "pk1")
    private String pk1Columns = "";

    @Column(name = "pk2")
    private String pk2Columns = "";

    @Column(name = "pk3")
    private String pk3Columns = "";

    @Column(name = "ds1")
    private String ds1Columns = "";

    @Column(name = "ds2")
    private String ds2Columns = "";

    @Column(name = "ds3")
    private String ds3Columns = "";

    @Column(name = "ds4")
    private String ds4Columns = "";
}
