package com.liuhaidongcoder.classloader;

import com.bj58.norman.App;

/**
 * @author Liu Haidong
 * @date 20/7/14
 */
public class Test {
    public static void main(String[] args) {

        Thread thread = new Thread(){
            @Override
            public void run() {

                while(true){
                    try {
                        MyClassLoader classLoader = new MyClassLoader("/Users/liuhaidong/IdeaProjects/norman-hdfs-demo/target/","test");
                        //Class<?> clazz = Class.forName("com.bj58.norman.App",true,classLoader);
                        Class<?> clazz = classLoader.findClass("com.bj58.norman.App");
                        System.out.println(clazz.hashCode());
                        clazz.newInstance();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //thread.start();
        MyClassLoader classLoader = new MyClassLoader("/Users/liuhaidong/IdeaProjects/norman-hdfs-demo/target/","test");
        try {
            Class<?> clazz = classLoader.findClass("/Users/liuhaidong/IdeaProjects/norman-hdfs-demo/src/main/resources/original-norman-common-1.0.0.jar");
            Object object = clazz.newInstance();
            System.out.println(clazz.getMethods());
            clazz.getMethod("setFirst",Object.class).invoke(object,"hello");
            System.out.println(clazz.getMethod("getFirst").invoke(object));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
