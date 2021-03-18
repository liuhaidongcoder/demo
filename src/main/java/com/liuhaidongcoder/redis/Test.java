package com.liuhaidongcoder.redis;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Liu Haidong
 * @date 20/8/14
 */
public class Test implements  Cloneable {
    public static void main(String[] args) throws CloneNotSupportedException, NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        System.out.printf("%X",new String(messageDigest.digest("hello".getBytes())));
    }
}
