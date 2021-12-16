package com.example.proyectoJavaDev.response;

import com.example.proyectoJavaDev.dto.EmployeeDto;

import java.io.Serializable;
import java.util.List;

public class EmployeeResponse implements Serializable {

    private List<EmployeeDto> listData;
    private PaginationResponse paginationResponse;

    public EmployeeResponse() {
    }

    public EmployeeResponse(List<EmployeeDto> listData, PaginationResponse paginationResponse) {
        this.listData = listData;
        this.paginationResponse = paginationResponse;
    }

    public List<EmployeeDto> getListData() {
        return listData;
    }

    public PaginationResponse getPaginationResponse() {
        return paginationResponse;
    }

    public void setListData(List<EmployeeDto> listData) {
        this.listData = listData;
    }

    public void setPaginationResponse(PaginationResponse paginationResponse) {
        this.paginationResponse = paginationResponse;
    }
}
