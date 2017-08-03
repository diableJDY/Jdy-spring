package com.jdy.spring.dao;

/**
 * Created by jdy on 2017-08-03.
 */
public class DaoFactory {
    public UserDao userDao(){
        ConnectionMaker connectionMaker=new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
