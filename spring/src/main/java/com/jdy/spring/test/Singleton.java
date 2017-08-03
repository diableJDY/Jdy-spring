package com.jdy.spring.test;

/**
 * Created by jdy on 2017-08-03.
 */
public class Singleton {

    private static Singleton singleton;

    public static Singleton getInstance(){

        return singleton;
    }

}
