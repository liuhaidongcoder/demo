package com.liuhaidongcoder.redis;

/**
 * @author Liu Haidong
 * @date 20/8/14
 */
public class Test implements  Cloneable {
    private int id;
    public static void main(String[] args) throws CloneNotSupportedException {
       Test test = new Test();
       Test test1 = (Test) test.clone();

        System.out.println(test == test1);
    }
}
