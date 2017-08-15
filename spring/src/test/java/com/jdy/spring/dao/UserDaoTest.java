package com.jdy.spring.dao;

import com.jdy.spring.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by jdy on 2017-08-03.
 */
public class UserDaoTest {

    //@Test

    /*public static void main(String[] args)throws ClassNotFoundException,SQLException {
        UserDao dao = new DaoFactory().userDao();

    }*/

    @Test
    public void addAndGet() throws SQLException, ClassNotFoundException {
        ApplicationContext context=new
                ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao dao=context.getBean("userDao",UserDao.class);
        User user=new User();
        user.setId("jdy118");
        user.setName("정대영");
        user.setPassword("1234");

        dao.add(user);

        User user1=dao.get(user.getId());

        assertThat(user1.getName() , is(user.getName()));
        assertThat(user1.getPassword() , is(user.getPassword()));

    }


}