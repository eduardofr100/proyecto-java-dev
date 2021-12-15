package com.example.proyectoJavaDev.dto;

import java.io.Serializable;

public class CatalogDto implements Serializable {
    private String nameCatalog;
    private String descriptionCatalog;

    public CatalogDto() {}

    public CatalogDto(String nameCatalog, String descriptionCatalog) {
        this.nameCatalog = nameCatalog;
        this.descriptionCatalog = descriptionCatalog;
    }

    public String getNameCatalog() {
        return nameCatalog;
    }

    public String getDescriptionCatalog() {
        return descriptionCatalog;
    }

    public void setNameCatalog(String nameCatalog) {
        this.nameCatalog = nameCatalog;
    }

    public void setDescriptionCatalog(String descriptionCatalog) {
        this.descriptionCatalog = descriptionCatalog;
    }
}
