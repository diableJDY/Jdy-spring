package com.jdy.spring.controller;

import com.jdy.spring.mapper.first.FirstMapper;
import com.jdy.spring.vo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jdy on 2017-07-31.
 */
@RestController
public class FirstController {

    @Autowired
    FirstMapper firstMapper;

    @RequestMapping("/")
    public String first(){
        List<Test> test  = firstMapper.getFirst();
        return "first";
    }



}
