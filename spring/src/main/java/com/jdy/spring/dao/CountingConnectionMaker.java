package com.jdy.spring.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by jdy on 2017-08-08.
 */
public class CountingConnectionMaker implements ConnectionMaker{
    int counter=0;
    private ConnectionMaker realConnectionMaker;

    public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
        this.realConnectionMaker = realConnectionMaker;
    }

    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        this.counter++;
        return realConnectionMaker.makeConnection();
    }


    public int getCounter() {
        return this.counter;
    }

}
