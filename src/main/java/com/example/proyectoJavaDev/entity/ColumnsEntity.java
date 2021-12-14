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

    public ColumnsEntity() {}

    public ColumnsEntity(Integer columnId, Integer catalogId, String pk1Columns, String pk2Columns, String pk3Columns,
                         String ds1Columns, String ds2Columns, String ds3Columns, String ds4Columns) {
        this.columnId = columnId;
        this.catalogId = catalogId;
        this.pk1Columns = pk1Columns;
        this.pk2Columns = pk2Columns;
        this.pk3Columns = pk3Columns;
        this.ds1Columns = ds1Columns;
        this.ds2Columns = ds2Columns;
        this.ds3Columns = ds3Columns;
        this.ds4Columns = ds4Columns;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public String getPk1Columns() {
        return pk1Columns;
    }

    public String getPk2Columns() {
        return pk2Columns;
    }

    public String getPk3Columns() {
        return pk3Columns;
    }

    public String getDs1Columns() {
        return ds1Columns;
    }

    public String getDs2Columns() {
        return ds2Columns;
    }

    public String getDs3Columns() {
        return ds3Columns;
    }

    public String getDs4Columns() {
        return ds4Columns;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public void setPk1Columns(String pk1Columns) {
        this.pk1Columns = pk1Columns;
    }

    public void setPk2Columns(String pk2Columns) {
        this.pk2Columns = pk2Columns;
    }

    public void setPk3Columns(String pk3Columns) {
        this.pk3Columns = pk3Columns;
    }

    public void setDs1Columns(String ds1Columns) {
        this.ds1Columns = ds1Columns;
    }

    public void setDs2Columns(String ds2Columns) {
        this.ds2Columns = ds2Columns;
    }

    public void setDs3Columns(String ds3Columns) {
        this.ds3Columns = ds3Columns;
    }

    public void setDs4Columns(String ds4Columns) {
        this.ds4Columns = ds4Columns;
    }
}
