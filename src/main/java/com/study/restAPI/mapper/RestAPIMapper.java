package com.study.restAPI.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface RestAPIMapper {

    HashMap<String, Object> findById(HashMap<String, Object> paramMap);

    void registerItem(HashMap<String, Object> paraMap); // insert에선 결과값을 받을게 없으니 void
    // mybatisX 플러그인 설치하면 굉장히 편해짐

}
