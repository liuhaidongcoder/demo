package com.liuhaidongcoder.unsafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Liu Haidong
 * @date 21/1/19
 */
public class SimpleDateFormatTest {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMDDHHmmss");
    static SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws ParseException {
        Date date = simpleDateFormat1.parse("2021-01-19 17:18:53.0");
        System.out.println(simpleDateFormat.format(date));
    }
}
