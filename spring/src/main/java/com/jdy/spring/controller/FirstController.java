package com.jdy.spring.controller;

import com.jdy.spring.dao.*;
import com.jdy.spring.domain.User;
import com.jdy.spring.mapper.first.FirstMapper;
import com.jdy.spring.test.Singleton;
import com.jdy.spring.vo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jdy on 2017-07-31.
 */
@RestController
public class FirstController {

    @Autowired
    FirstMapper firstMapper;


    @RequestMapping("/")
    public List<Test> first(){
        List<Test> test  = firstMapper.getFirst();
        return test;
    }


    /*@RequestMapping("/study")
    public void study()throws ClassNotFoundException,SQLException{
        //NUserDao dao = new NUserDao();

        User user=new User();
        user.setId("cym2");
        user.setName("최유미");
        user.setPassword("1234");

        dao.add(user);


        System.out.println(user.getId()+ "등록 성공");

        User user2= dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());


        System.out.println(user2.getId() + "조회성공");


    }*/

    @RequestMapping("/daoStudy")
    public void daoStudy()throws ClassNotFoundException,SQLException{
        ConnectionMaker connectionMaker=new DConnectionMaker();

        //UserDao dao =new UserDao(connectionMaker);
        UserDao dao =new UserDao();
        dao.setConnectionMaker(connectionMaker);


        User user=new User();
        user.setId("cym4");
        user.setName("최유미");
        user.setPassword("1234");

        dao.add(user);


        System.out.println(user.getId()+ "등록 성공");

        User user2= dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());


        System.out.println(user2.getId() + "조회성공");

    }

    @RequestMapping("/single")
    public void testSingle(){
        Singleton singleton1 = Singleton.getInstance();

        Singleton singleton2 = Singleton.getInstance();

        if(singleton1 == singleton2){
            System.out.println("같은 singleton 객체");
        }else{
            System.out.println("다른 singleton 객체");
        }

    }



}

















