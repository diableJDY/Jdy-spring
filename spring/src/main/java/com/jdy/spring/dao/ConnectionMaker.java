package com.jdy.spring.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by jdy on 2017-08-01.
 */
public interface ConnectionMaker {
    public Connection makeConnection()throws ClassNotFoundException,SQLException;
}
