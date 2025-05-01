package com.study.restAPI.controller;

import com.study.restAPI.dto.ItemDto;
import com.study.restAPI.dto.ResponseDto;
import com.study.restAPI.service.RestAPIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j // lombok, log찍기 위함
public class RestAPIController {

    // Ctrl + Alt + Enter = 현재 중 위에 빈 줄 삽입
    //      Shift + Enter = 현재 줄 아래에 빈 줄 삽입

    @Autowired
    private RestAPIService restAPIService;
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

    // parameter 받을 때는 @RequestParam 또는 @PathVariable
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

    // Parameter를 Body쪽, Body를 통해서 받고 싶으면 @RequestBody
    // 보통 JSON으로 주고 받기 때문에 JSON 형태의 DTO를 만들고 이용
    @PostMapping("/item")
    public ResponseDto registerItem(@RequestBody ItemDto item) {
        log.info("item: {}", item);

//      RestAPIService restAPIService = new RestAPIService(); @Autowired가 없으면 써야 함
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

    @GetMapping("/item")
    public ItemDto getItem(@RequestParam("id") String id) {
        ItemDto res = restAPIService.getItemById(id);

        return res;
    }

}
