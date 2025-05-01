package com.study.restAPI.service;

import com.study.restAPI.dto.ItemDto;
import com.study.restAPI.mapper.RestAPIMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service // Spring이 알아서 객체를 만들어줌(new)
@Slf4j
public class RestAPIService {

    @Autowired
    private RestAPIMapper restAPIMapper;

    // @Service는 해당 클래스를 Spring Bean으로 등록하고
    // @Autowired는 등록된 Bean을 필요한 곳에 자동으로 주입해주는 역할을 함

    public boolean registerItem(ItemDto itemDto) {
        // TODO: DB insert (실무에선 여기에 DB insert 작업)

        HashMap<String, Object> paramMap = new HashMap<>();

        paramMap.put("id", itemDto.getId());
        paramMap.put("name", itemDto.getName());

        restAPIMapper.registerItem(paramMap);

        log.info("restAPIService 거치는 중...");

        return true;
    }

    public ItemDto getItemById(String id) {

        // H2 DB에 있는 ID, NAME 가져오는 것 (MyBatis 이용)
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);

        HashMap<String, Object> res = restAPIMapper.findById(paramMap);

        ItemDto itemDto = new ItemDto();
        itemDto.setId((String)res.get("ID"));
        itemDto.setName((String)res.get("NAME"));

        return itemDto;
    }

}
