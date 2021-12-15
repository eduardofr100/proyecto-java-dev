package com.example.proyectoJavaDev.dto.common;

import java.util.List;

public class PageableResponse<T>{

    private List<T> data;
    private Metadata metadata;

    public PageableResponse(List<T> data, Metadata metadata) {
        this.data = data;
        this.metadata = metadata;
    }
}
