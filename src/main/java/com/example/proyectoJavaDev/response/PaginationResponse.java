package com.example.proyectoJavaDev.response;

public class PaginationResponse {

    private int size;
    private int currentPag;
    private long totalElements;
    private int totalPages;
    private boolean sorted;
    private boolean last;

    public PaginationResponse() {
    }

    public PaginationResponse(int size, int currentPag, long totalElements, int totalPages, boolean sorted, boolean last) {
        this.size = size;
        this.currentPag = currentPag;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.sorted = sorted;
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public int getCurrentPag() {
        return currentPag;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public boolean isSorted() {
        return sorted;
    }

    public boolean isLast() {
        return last;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCurrentPag(int currentPag) {
        this.currentPag = currentPag;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
}
