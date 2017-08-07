package com.jdy.spring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jdy on 2017-08-03.
 */
@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao(){
        ConnectionMaker connectionMaker=new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
