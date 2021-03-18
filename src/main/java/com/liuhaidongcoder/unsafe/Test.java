package com.liuhaidongcoder.unsafe;

import sun.misc.JavaLangAccess;
import sun.misc.SharedSecrets;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Liu Haidong
 * @date 21/1/13
 */
public class Test {
    public static void main(String[] args) throws NoSuchFieldException {
        /*Test test = new Test();
        test.hello();*/
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void hello(){
        JavaLangAccess access = SharedSecrets.getJavaLangAccess();
        Throwable throwable = new Throwable();
        int length = access.getStackTraceDepth(throwable);
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        for(int i=0;i < stackTraceElements.length;i++){
            System.out.println("s");
            System.out.println(stackTraceElements[i]);
            System.out.println("e");
        }

        for(int i=0;i < length;i++){
            System.out.println("start");
            System.out.println(throwable.getStackTrace()[i]);
            System.out.println("end");
        }
    }
}
