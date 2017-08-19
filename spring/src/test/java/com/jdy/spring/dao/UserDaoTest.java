package com.jdy.spring.dao;

import com.jdy.spring.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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

        dao.deleteAll();
        assertThat(dao.getCount(),is(0));


        User user=new User();
        user.setId("jdy118");
        user.setName("정대영");
        user.setPassword("1234");

        dao.add(user);

        assertThat(dao.getCount(),is(1));

        User user1=dao.get(user.getId());

        assertThat(user1.getName() , is(user.getName()));
        assertThat(user1.getPassword() , is(user.getPassword()));

    }


    @Test
    public void count() throws SQLException,ClassNotFoundException{
        ApplicationContext context=new
                ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao dao=context.getBean("userDao",UserDao.class);
        User user=new User("jdy111","정대영111","1111");
        User user1=new User("jdy222","정대영222","2222");
        User user2=new User("jdy333","정대영333","3333");

        dao.deleteAll();
        assertThat(dao.getCount(),is(0));

        dao.add(user);
        assertThat(dao.getCount(),is(1));

        dao.add(user1);
        assertThat(dao.getCount(),is(2));

        dao.add(user2);
        assertThat(dao.getCount(),is(3));
    }


    @Test(expected = SQLException.class)
    public void getUserFailure() throws SQLException,ClassNotFoundException{

        ApplicationContext context=new GenericXmlApplicationContext("applicationContext.xml");

        UserDao dao=context.getBean("userDao",UserDao.class);
        dao.deleteAll();
        assertThat(dao.getCount(),is(0));

        dao.get("unknown_id");



    }

}