package com.study.restAPI.service;

import com.study.restAPI.dto.ItemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service // Spring이 알아서 객체를 만들어줌(new)
@Slf4j
public class restAPIService {

    // @Service는 해당 클래스를 Spring Bean으로 등록하고
    // @Autowired는 등록된 Bean을 필요한 곳에 자동으로 주입해주는 역할을 함

    public boolean registerItem(ItemDto itemDto) {
        // TODO: DB insert (실무에선 여기에 DB insert 작업)

        log.info("restAPIService 거치는 중...");

        return true;
    }

}
