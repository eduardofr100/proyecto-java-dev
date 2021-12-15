package com.example.proyectoJavaDev.response;

import java.util.List;

public class EmployeeResponse<T> {

    private List<T> listData;
    private PaginationResponse paginationResponse;

    public EmployeeResponse() {
    }

    public EmployeeResponse(List<T> listData, PaginationResponse paginationResponse) {
        this.listData = listData;
        this.paginationResponse = paginationResponse;
    }

}
