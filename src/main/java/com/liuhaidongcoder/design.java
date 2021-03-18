package com.liuhaidongcoder;

import java.util.Locale;

/**
 * @author Liu Haidong
 * @date 21/3/16
 */
public class design {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println(locale.getLanguage());
        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale.getCountry());
        System.out.println(locale.getDisplayCountry());
        System.out.println(System.getProperties());
    }
}
