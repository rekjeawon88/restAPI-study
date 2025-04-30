package com.study.restAPI.controller;

import com.study.restAPI.dto.ItemDto;
import com.study.restAPI.dto.ResponseDto;
import com.study.restAPI.service.restAPIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class restAPIController {

    // Ctrl + Alt + Enter = 현재 중 위에 빈 줄 삽입
    //      Shift + Enter = 현재 줄 아래에 빈 줄 삽입

    @Autowired
    private restAPIService restAPIService;
    // @Service는 해당 클래스를 Spring Bean으로 등록하고
    // @Autowired는 등록된 Bean을 필요한 곳에 자동으로 주입해주는 역할을 함


    @GetMapping("/dummy")
    public String dummy() {
        log.info("dummy");
        return "dummy";
    }

    @GetMapping("/dummy2")
    public String dummy2() {
        log.info("dummy2");
        return "dummy2";
    }

    @GetMapping("/member")
    public String getMember(@RequestParam("empNo") String empNo,
                            @RequestParam("year") int year) {
        log.info("empNo: {}", empNo);
        log.info("year: {}", year);
        return "ok";
        // Request URL: http://127.0.0.1:8080/member?empNo=1234&year=1990
    }

    @GetMapping("/compony/{id}")
    public String getCompany(@PathVariable("id") String id) {
        log.info("id: {}", id);
        return "ok";
        // Request URL: http://127.0.0.1:8080/compony/8888
    }

    @PostMapping("/item")
    public ResponseDto registerItem(@RequestBody ItemDto item) {
        log.info("item: {}", item);

//      restAPIService restAPIService = new restAPIService(); @Autowired가 없으면 써야 함
        boolean result = restAPIService.registerItem(item);
        if(result == true) { // restAPIService에 있는 작업이 성공한다면
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("success");
            return responseDto;
        }

        // restAPIService에 있는 작업이 실패한다면
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("fail");
        return responseDto;
        // Body를 보내기 때문에 Body에 해당하는 거라고 알리기 위해 @RequestBody
        // Dto가 데이터 받는 거를 String이 아닌 JSON등 다양한 형식으로 받을 수 있게 해줌
    }

}
