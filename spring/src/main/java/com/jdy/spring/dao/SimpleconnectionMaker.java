package com.jdy.spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by jdy on 2017-08-01.
 */
public class SimpleconnectionMaker {
    public Connection makeNewConnection()throws ClassNotFoundException,SQLException{

        Class.forName("com.mysql.jdbc.Driver");
        return  DriverManager
                .getConnection("jdbc:mysql://localhost/jdy", "root", "1234");
    }
}
