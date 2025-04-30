package com.study.restAPI.controller;

import com.study.restAPI.dto.ItemDto;
import com.study.restAPI.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class restAPIController {

    // Ctrl + Alt + Enter = 현재 중 위에 빈 줄 삽입
    //      Shift + Enter = 현재 줄 아래에 빈 줄 삽입

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
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("ok");
        return responseDto;
        // Body를 보내기 때문에 Body에 해당하는 거라고 알리기 위해 @RequestBody
        // Dto가 데이터 받는 거를 String이 아닌 JSON등 다양한 형식으로 받을 수 있게 해줌
    }

}
