package com.it_item_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentStoreApp {

    @RequestMapping("/") 
    public String hello() {
        return "Hello World!";
    }
    
}