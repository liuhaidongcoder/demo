package com.liuhaidongcoder.unsafe;

import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author Liu Haidong
 * @date 21/1/13
 */
public class UnsafeTest {

    static Object object = new Object();
    public static void main(String[] args) throws NoSuchFieldException, InterruptedException {

        for(Map.Entry entry: System.getenv().entrySet()){
            System.out.println("key:"+entry.getKey() + "  value:"+entry.getValue());
        }

        for(Map.Entry entry: System.getProperties().entrySet()){
            System.out.println("key:"+entry.getKey() + "  value:"+entry.getValue());
        }


   /*     Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = null;
        try {
            unsafe = (Unsafe) field.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Object object1 = new Object();
        Thread.sleep(5000);
        System.out.println(unsafe.getClass().getSuperclass());
        System.out.println(ClassLayout.parseInstance(unsafe.getClass()).toPrintable());

        for(int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                    lock();
                }
            }.start();
        }


        System.out.println(ClassLayout.parseInstance(object).toPrintable());


        object1.hashCode();

        System.out.println("start");
        System.out.println(unsafe.getByte(object, 0L));
        System.out.println(unsafe.getByte(object, 1L));
        System.out.println(unsafe.getByte(object, 2L));
        System.out.println(unsafe.getByte(object, 3L));
        System.out.println(unsafe.getByte(object, 4L));
        System.out.println(unsafe.getByte(object, 5L));
        System.out.println(unsafe.getByte(object, 6L));
        System.out.println(unsafe.getByte(object, 7L));
        System.out.println("end");

        synchronized (object){
            System.out.println("start");
            System.out.println(unsafe.getByte(object, 0L));
            System.out.println(unsafe.getByte(object, 1L));
            System.out.println(unsafe.getByte(object, 2L));
            System.out.println(unsafe.getByte(object, 3L));
            System.out.println(unsafe.getByte(object, 4L));
            System.out.println(unsafe.getByte(object, 5L));
            System.out.println(unsafe.getByte(object, 6L));
            System.out.println(unsafe.getByte(object, 7L));
            System.out.println("end");
        }


        long base = unsafe.allocateMemory(10);
        unsafe.setMemory(base, 10, (byte) 0);
        System.out.println(unsafe.getInt(object1, 0L));
        System.out.println(unsafe.getByte(object1, 1L));
        System.out.println(unsafe.getByte(object1, 2L));
        System.out.println(unsafe.getByte(object1, 3L));
        System.out.println(unsafe.getByte(object1, 4L));
        System.out.println(unsafe.getByte(object1, 5L));
        System.out.println(unsafe.getByte(object1, 6L));
        System.out.println(unsafe.getByte(object1, 7L));
        //System.out.println(base);

        System.out.println(base % unsafe.pageSize() == 0);*/

    }
    static void lock(){
        synchronized (object){
            try {
                System.out.println(ClassLayout.parseInstance(object).toPrintable());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
