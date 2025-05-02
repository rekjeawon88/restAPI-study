package com.study.restAPI.repository;

import com.study.restAPI.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, String> {

    // Entity의 Primary Key가 String 이므로 <ItemEntity, String>이 됨

}
