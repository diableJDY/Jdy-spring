package com.jdy.spring.dao;

import com.jdy.spring.domain.User;

import java.sql.*;

/**
 * Created by jdy on 2017-08-01.
 */
public class UserDao {

        //private  SimpleconnectionMaker simpleconnectionMaker;
        private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        //simpleconnectionMaker = new SimpleconnectionMaker();
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        /*Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager
                .getConnection("jdbc:mysql://localhost/jdy", "root", "1234");
*/
        //Connection c = getConnection();
        //Connection c=simpleconnectionMaker.makeNewConnection();
        Connection c= connectionMaker.makeConnection();

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

        //Connection c = getConnection();
        //Connection c=simpleconnectionMaker.makeNewConnection();
        Connection c= connectionMaker.makeConnection();


        PreparedStatement ps = c.prepareStatement("" +
                "select * from users where id = ?");
        ps.setString(1, id);


        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId((rs.getString("id")));
        user.setName((rs.getString("name")));
        user.setPassword((rs.getString("password")));

        rs.close();
        ps.close();
        c.close();


        return user;
    }

    /*public Connection getConnection() throws ClassNotFoundException,SQLException{

        Class.forName("com.mysql.jdbc.Driver");
        return  DriverManager
                .getConnection("jdbc:mysql://localhost/jdy", "root", "1234");

    }*/

   /* public abstract Connection getConnection() throws ClassNotFoundException, SQLException;*/

}


