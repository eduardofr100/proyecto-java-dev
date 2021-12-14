package com.example.proyectoJavaDev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "catalogo")
public class CatalogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_catalogo")
    private Integer catalogId = 0;

    @Column(name = "nombre_catalogo")
    private String nameCatalog = "";

    @Column(name = "ds_catalogo")
    private String descriptionCatalog = "";

    public CatalogEntity() {}

    public CatalogEntity(Integer catalogId, String nameCatalog, String descriptionCatalog) {
        this.catalogId = catalogId;
        this.nameCatalog = nameCatalog;
        this.descriptionCatalog = descriptionCatalog;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public String getNameCatalog() {
        return nameCatalog;
    }

    public String getDescriptionCatalog() {
        return descriptionCatalog;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public void setNameCatalog(String nameCatalog) {
        this.nameCatalog = nameCatalog;
    }

    public void setDescriptionCatalog(String descriptionCatalog) {
        this.descriptionCatalog = descriptionCatalog;
    }
}
