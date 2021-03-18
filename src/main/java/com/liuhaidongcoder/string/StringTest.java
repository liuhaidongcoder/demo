package com.liuhaidongcoder.string;

import jdk.nashorn.api.scripting.URLReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * @author Liu Haidong
 * @date 21/2/1
 */
public class StringTest {
    public static void main(String[] args) {
    /*    String str = "你好";
        System.out.println(str.codePointAt(0));
        System.out.println(str.codePointBefore(1));
        System.out.println(str.codePointCount(0,2));
        System.out.println(str.compareTo("好"));
        str.split("");
        System.out.println(str.matches("\\S{2,}"));

        StringJoiner stringJoiner = new StringJoiner(",");
        stringJoiner.add("hello");
        stringJoiner.add("world");
        System.out.println(stringJoiner.toString());

        StringTokenizer stringTokenizer =  new StringTokenizer("hello,world",",");
        System.out.println(stringTokenizer.countTokens());
        while (stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }*/

        try {
            URL url = new URL("https://www.cnblogs.com/yangming1996/p/7168353.html");
            BufferedReader inputStream = new BufferedReader(new URLReader(url));
            inputStream.read();
            String line = null;
            while ((line=inputStream.readLine()) != null){
                System.out.println(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
