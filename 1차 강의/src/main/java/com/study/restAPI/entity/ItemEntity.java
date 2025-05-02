package com.study.restAPI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ITEM") // 실제 DB에 있는 물리 테이블 이름
public class ItemEntity {

    @Id // Primary Key이기 때문에 @Id 넣어줌
    private String id;

    private String name;

    // private이기 때문에 접근이 안되서 Getter, Setter 생성
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
