package com.study.restAPI.dto;

public class ItemDto {

    private String id;
    private String name;

    // Alt + Ins 누르면 빠르게 Getter, Setter 설정 가능
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
