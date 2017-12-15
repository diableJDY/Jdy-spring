package com.jdy.spring.controller;

import com.jdy.spring.dao.JUser;
import com.jdy.spring.mapper.first.FirstMapper;
import com.jdy.spring.mapper.user.UserMapper;
import com.jdy.spring.vo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

//import javax.annotation.Resource;

/**
 * Created by jdy on 2017-07-31.
 */
@Controller
public class FirstController {

    @Resource
    FirstMapper firstMapper;

    @Autowired
    UserMapper userMapper;


    @RequestMapping("/")
    @ResponseBody
    public List<Test> first() {
        List<Test> test = firstMapper.getFirst();
        Test test1 = new Test();

        test1.setId(1);
        test1.setAge("35");
        test1.setName("j9y");
        test.add(test1);
        return test;
    }


    @RequestMapping("/jdys")
    @ResponseBody
    public String hello1() {
        return "hello spring";
    }

    @RequestMapping("/jdy")
    @ResponseBody
    public String hello() {
        return "hello spring";
    }


    @RequestMapping("/{name}")
    public JUser home(@PathVariable String name) {
        JUser user = userMapper.readUser(name);
        return user;
    }

    /*@RequestMapping("/study")
    public void study()throws ClassNotFoundException,SQLException{
        //NUserDao dao = new NUserDao();

        User user=new User();
        user.setId("cym2");
        user.setName("理쒖쑀誘�");
        user.setPassword("1234");

        dao.add(user);


        System.out.println(user.getId()+ "�벑濡� �꽦怨�");

        User user2= dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());


        System.out.println(user2.getId() + "議고쉶�꽦怨�");


    }*/

    /*@RequestMapping("/daoStudy")
    public void daoStudy()throws ClassNotFoundException,SQLException{
        ConnectionMaker connectionMaker=new DConnectionMaker();

        //UserDao dao =new UserDao(connectionMaker);
        UserDao dao =new UserDao();
        dao.setConnectionMaker(connectionMaker);


        User user=new User();
        user.setId("cym4");
        user.setName("理쒖쑀誘�");
        user.setPassword("1234");

        dao.add(user);


        System.out.println(user.getId()+ "�벑濡� �꽦怨�");

        User user2= dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());


        System.out.println(user2.getId() + "議고쉶�꽦怨�");

    }

    @RequestMapping("/single")
    public void testSingle(){
        Singleton singleton1 = Singleton.getInstance();

        Singleton singleton2 = Singleton.getInstance();

        if(singleton1 == singleton2){
            System.out.println("媛숈� singleton 媛앹껜");
        }else{
            System.out.println("�떎瑜� singleton 媛앹껜");
        }

    }
*/


}

















