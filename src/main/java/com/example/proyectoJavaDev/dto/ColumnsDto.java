package com.example.proyectoJavaDev.dto;

import java.io.Serializable;

public class ColumnsDto implements Serializable {
    private String pk1Columns;
    private String pk2Columns;
    private String pk3Columns;
    private String ds1Columns;
    private String ds2Columns;
    private String ds3Columns;
    private String ds4Columns;

    public ColumnsDto() {}

    public ColumnsDto(String pk1Columns, String pk2Columns, String pk3Columns, String ds1Columns, String ds2Columns,
                      String ds3Columns, String ds4Columns) {
        this.pk1Columns = pk1Columns;
        this.pk2Columns = pk2Columns;
        this.pk3Columns = pk3Columns;
        this.ds1Columns = ds1Columns;
        this.ds2Columns = ds2Columns;
        this.ds3Columns = ds3Columns;
        this.ds4Columns = ds4Columns;
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
