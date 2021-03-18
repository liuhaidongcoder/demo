package com.liuhaidongcoder.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Liu Haidong
 * @date 21/2/1
 */
public class PatternTest {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile(".+");
        Matcher matcher = pattern.matcher("12好abc123ababc1234");

        while (matcher.find()){
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println(matcher.group());
        }
        /*System.out.println(matcher.find());
        System.out.println(matcher.groupCount());
        System.out.println(matcher.start());
        System.out.println(matcher.end());*/

        String.join("-",new String[]{"hello","world"});


        System.out.println(matcher.matches());


        Pattern.matches(".*","");
    }
}
