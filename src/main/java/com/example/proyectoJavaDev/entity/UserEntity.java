package com.example.proyectoJavaDev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nombre de la tabla")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer userId = 0;

    @Column(name = "nombre")
    private String name = "";

    @Column(name = "ap_paterno")
    private String firstname = "";

    @Column(name = "ap_materno")
    private String lastname = "";

    @Column()
    private Integer age = 0;
    private Boolean status = false;
}
