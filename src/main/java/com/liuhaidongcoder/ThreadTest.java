package com.liuhaidongcoder;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author Liu Haidong
 * @date 21/1/12
 */
public class ThreadTest {
    public static void main(String[] args) {

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Exception ThreadGroup:" + t.getThreadGroup() + "threadName :" +t.getName() + e.getMessage());
            }
        });

        Thread myThead = new Thread(){
            @Override
            public void run(){
                int i = 0;
                while (i < 10) {
                    System.out.println("hello");
                    try {
                        System.out.println(3/0);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }

            }
        };
        myThead.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Exception hh ThreadGroup:" + t.getThreadGroup() + "threadName :" +t.getName() + e.getMessage());
            }
        });
        myThead.setName("test1");
        myThead.start();

        Thread myDeamonThead = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(3 / 0);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        myDeamonThead.setDaemon(true);
        myDeamonThead.setName("test2");
        myDeamonThead.start();
        System.out.println(myDeamonThead.getThreadGroup());

        System.out.println(myThead.getName());
        System.out.println(myThead.getThreadGroup());

        System.out.println(myDeamonThead.getName());
        System.out.println(myDeamonThead.getThreadGroup());

        test:
        for(;;){
            System.out.println("hellow");
            for(;;){
                continue test;
            }
        }
    }
}
