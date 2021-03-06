package com.jdy.spring.dao;

import com.jdy.spring.domain.User;

import java.sql.*;

/**
 * Created by jdy on 2017-08-01.
 */
public class UserDao {

    private ConnectionMaker connectionMaker;

    private Connection c;
    private User user;

    public UserDao(){

    }

    public UserDao(ConnectionMaker connectionMaker) {

        this.connectionMaker = connectionMaker;
    }
    public void setConnectionMaker(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("" +
                "insert into users(id,name,password) values(?,?,?)");

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {

        this.c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("" +
                "select * from users where id = ?");
        ps.setString(1, id);


        ResultSet rs = ps.executeQuery();
        rs.next();
        this.user = new User();
        this.user.setId((rs.getString("id")));
        this.user.setName((rs.getString("name")));
        this.user.setPassword((rs.getString("password")));

        rs.close();
        ps.close();
        c.close();


        return this.user;
    }

    public void deleteAll() throws ClassNotFoundException,SQLException{
        this.c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("delete from users");

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public int getCount() throws ClassNotFoundException,SQLException{
        this.c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("select count(*) from users");

        ResultSet rs=ps.executeQuery();
        rs.next();
        int count = rs.getInt(1);

        rs.close();
        ps.close();
        c.close();

        return count;
    }
}


