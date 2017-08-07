package com.jdy.spring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jdy on 2017-08-08.
 */
@Configuration
public class CountingDaoFactory {


    @Bean
    public UserDao userDao(){
        return new UserDao(connectionMaker());
    }

    @Bean
    private ConnectionMaker connectionMaker() {
        return new CountingConnectionMaker(realConnectionMaker());
    }

    @Bean
    private ConnectionMaker realConnectionMaker() {
        return new DConnectionMaker();
    }


}
