package com.example.proyectoJavaDev.dto;

import java.io.Serializable;

public class RecordsDto implements Serializable {
    private String pk1Records;
    private String pk2Records;
    private String pk3Records;
    private String ds1Records;
    private String ds2Records;
    private String ds3Records;
    private String ds4Records;

    public RecordsDto() {}

    public RecordsDto(String pk1Records, String pk2Records, String pk3Records, String ds1Records, String ds2Records,
                      String ds3Records, String ds4Records) {
        this.pk1Records = pk1Records;
        this.pk2Records = pk2Records;
        this.pk3Records = pk3Records;
        this.ds1Records = ds1Records;
        this.ds2Records = ds2Records;
        this.ds3Records = ds3Records;
        this.ds4Records = ds4Records;
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
