package com.jdy.spring.test;

import com.jdy.spring.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jdy on 2017-08-09.
 */
public class RestTest {

    @Test
    public void addAndGet() throws Exception{
        ApplicationContext applicationContext = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao dao = applicationContext.getBean("UserDao",UserDao.class);

        int cnt = dao.getCount();

        Assert.assertEquals(cnt,3);

    }
}
