package com.ycao.webservertestdemo.controller;

import com.ycao.webservertestdemo.utils.APIResponse;
import com.ycao.webservertestdemo.utils.CommonUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/test")
public class TestDemo {

    @GetMapping(value = "/msg")
    APIResponse getTestMessage(){
        return APIResponse.success("This is what you got from the server: "+ CommonUtils.getRandomID());
    }
}
