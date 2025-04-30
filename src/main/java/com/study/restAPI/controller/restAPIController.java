package com.study.restAPI.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class restAPIController {

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

}
