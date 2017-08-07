package com.jdy.spring.dao;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by jdy on 2017-08-07.
 */
public class ApplicationTest {

    @Test
    public void jdyTest(){
        ApplicationContext context = new
                AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao3= context.getBean("userDao",UserDao.class);
        UserDao dao4= context.getBean("userDao",UserDao.class);

        System.out.println(dao3);
        System.out.println(dao4);

        System.out.println(dao3.equals(dao4));
    }

}
