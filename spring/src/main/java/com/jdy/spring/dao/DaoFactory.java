package com.jdy.spring.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jdy on 2017-08-03.
 */
@Configuration //애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시
public class DaoFactory {

    @Bean//오브젝트 생성을 담당하는 ioc용 메소드라는 표시
    public UserDao userDao(){
       /* ConnectionMaker connectionMaker=new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;*/
       UserDao userDao=new UserDao();
       userDao.setConnectionMaker(connectionMaker());
       return userDao;
    }


    @Bean
    public ConnectionMaker connectionMaker(){
        return new LocalDBConnectionMaker();
    }


}
