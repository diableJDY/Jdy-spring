package com.jdy.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jdy on 2017-07-31.
 */
@RestController
public class FirstController {


    @RequestMapping("/")
    public String first(){
        return "first";
    }
}
