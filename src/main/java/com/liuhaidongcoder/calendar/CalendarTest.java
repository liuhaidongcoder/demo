package com.liuhaidongcoder.calendar;

import sun.util.locale.provider.LocaleProviderAdapter;
import sun.util.spi.CalendarProvider;

import java.util.Calendar;
import java.util.Locale;

/**
 * @author Liu Haidong
 * @date 21/3/16
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.AM));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        System.out.println(LocaleProviderAdapter.getAdapter(CalendarProvider.class, Locale.getDefault()).getClass().getSimpleName());
        new Calendar.Builder().build();
    }
}
