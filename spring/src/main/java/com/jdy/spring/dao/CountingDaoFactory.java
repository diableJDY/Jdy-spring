package com.jdy.spring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jdy on 2017-08-08.
 */
@Configuration
public class CountingDaoFactory {


    @Bean
    public UserDao userDao()throws Exception{
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() throws Exception{
        return new CountingConnectionMaker(realConnectionMaker());
    }

    @Bean
    public ConnectionMaker realConnectionMaker() throws Exception {
        return new DConnectionMaker();
    }


}
