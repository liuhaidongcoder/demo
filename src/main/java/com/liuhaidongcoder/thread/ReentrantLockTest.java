package com.liuhaidongcoder.thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Liu Haidong
 * @date 21/1/13
 */
public class ReentrantLockTest {
    private static ExecutorService executorService = new ThreadPoolExecutor(10,10,10, TimeUnit.SECONDS,new LinkedBlockingDeque<>(10),new MyThreadFactory("test"));
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            executorService.submit(new MyThread());
        }

    }
    private static class MyThreadFactory implements ThreadFactory{
        private AtomicInteger atomicInteger = new AtomicInteger(0);
        private String name;
        public MyThreadFactory(String name) {
            this.name = name;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName(String.format(name + "-%s",atomicInteger.getAndIncrement()));
            return thread;
        }
    }
    private static class MyThread implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread:" +Thread.currentThread().getName() + " start acquire lock");
            reentrantLock.lock();
            try{
                System.out.println("Thread:" +Thread.currentThread().getName() + "  owner lock");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
                System.out.println("Thread:" +Thread.currentThread().getName() + "  release lock");
            }
        }
    }
}
