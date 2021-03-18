package com.liuhaidongcoder.demo;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author Liu Haidong
 * @date 21/1/27
 */
public class HelloJava {
    static String global = "hello java";
    public static void main(String[] args) throws MalformedURLException, InterruptedException, UnsupportedEncodingException {
       /* URL url = new URL("file:/Users/liuhaidong/IdeaProjects/Demo/sdk.jar");
        System.out.println(url.getPath());
        URL[] urls = new URL[]{url};
        URLClassLoader urlClassLoader = new URLClassLoader(urls,null);
        URLClassLoader urlClassLoader2 = new URLClassLoader(urls,null);
        try {
            Class clazz = urlClassLoader.loadClass("com.yunchuangyouzhi.server.SDKServer");
            Class clazz1 = urlClassLoader.loadClass("com.yunchuangyouzhi.server.SDKServer");
            System.out.println(clazz.getClassLoader());
            System.out.println(clazz.getDeclaredField("logger").getType().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        while (true){
            Thread.sleep(1000);
        }*/

       /* try {
            String s = "";
            Field field = s.getClass().getDeclaredField("value");
            field.setAccessible(true);
            field.get(s);
            String s1 = new String();
            Field field1 = s.getClass().getDeclaredField("value");
            field1.setAccessible(true);
            System.out.println(field.get(s1)==field.get(s));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/
        String s = "你";
        byte[] bytes = s.getBytes("UTF-8");
        System.out.println(new String(bytes,"GBK"));
        System.out.println();

        Charset charset = Charset.forName("GBK");
        System.out.println(Charset.isSupported("GBK"));
        System.out.println(charset.encode("h"));



        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('h');
        stringBuilder.append('0');
        System.out.println(stringBuilder.toString());
        StringBuffer stringBuffer = new StringBuffer();

        String.valueOf(65536);

        int target = 65536;
        int i=0;
        if(target < 10)
            i=1;
        while(target/10>0){
            i++;
            target /=10;
        }
        System.out.println(i);
    }
}
