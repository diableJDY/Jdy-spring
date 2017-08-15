package com.jdy.spring.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by jdy on 2017-08-15.
 */
public class UserDaoConnectionCountingTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao = context.getBean("userDao",UserDao.class);


        CountingConnectionMaker ccm =context.getBean("connectionMaker",CountingConnectionMaker.class);
        System.out.println("Connection couter:" + ccm.getCounter());

    }
}