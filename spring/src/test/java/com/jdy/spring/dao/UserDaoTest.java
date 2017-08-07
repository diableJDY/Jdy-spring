package com.jdy.spring.dao;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by jdy on 2017-08-03.
 */
public class UserDaoTest {

    //@Test

    public static void main(String[] args)throws ClassNotFoundException,SQLException {
        UserDao dao = new DaoFactory().userDao();

    }


}