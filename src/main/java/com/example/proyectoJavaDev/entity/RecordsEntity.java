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

    public RecordsEntity() {}

    public RecordsEntity(Integer recordId, Integer catalogId, String pk1Records, String pk2Records, String pk3Records,
                         String ds1Records, String ds2Records, String ds3Records, String ds4Records) {
        this.recordId = recordId;
        this.catalogId = catalogId;
        this.pk1Records = pk1Records;
        this.pk2Records = pk2Records;
        this.pk3Records = pk3Records;
        this.ds1Records = ds1Records;
        this.ds2Records = ds2Records;
        this.ds3Records = ds3Records;
        this.ds4Records = ds4Records;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public Integer getCatalogId() {
        return catalogId;
    }

    public String getPk1Records() {
        return pk1Records;
    }

    public String getPk2Records() {
        return pk2Records;
    }

    public String getPk3Records() {
        return pk3Records;
    }

    public String getDs1Records() {
        return ds1Records;
    }

    public String getDs2Records() {
        return ds2Records;
    }

    public String getDs3Records() {
        return ds3Records;
    }

    public String getDs4Records() {
        return ds4Records;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public void setCatalogId(Integer catalogId) {
        this.catalogId = catalogId;
    }

    public void setPk1Records(String pk1Records) {
        this.pk1Records = pk1Records;
    }

    public void setPk2Records(String pk2Records) {
        this.pk2Records = pk2Records;
    }

    public void setPk3Records(String pk3Records) {
        this.pk3Records = pk3Records;
    }

    public void setDs1Records(String ds1Records) {
        this.ds1Records = ds1Records;
    }

    public void setDs2Records(String ds2Records) {
        this.ds2Records = ds2Records;
    }

    public void setDs3Records(String ds3Records) {
        this.ds3Records = ds3Records;
    }

    public void setDs4Records(String ds4Records) {
        this.ds4Records = ds4Records;
    }
}
