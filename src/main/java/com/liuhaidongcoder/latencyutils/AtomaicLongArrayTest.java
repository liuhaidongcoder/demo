package com.liuhaidongcoder.latencyutils;

import java.util.concurrent.atomic.AtomicLongArray;

/**
 * @author Liu Haidong
 * @date 20/5/26
 */
public class AtomaicLongArrayTest {
    public static void main(String[] args) {
        AtomicLongArray  atomicLongArray = new AtomicLongArray(10);

        System.out.println(atomicLongArray.addAndGet(1,10));
        System.out.println(atomicLongArray.addAndGet(1,1));
        System.out.println(atomicLongArray.decrementAndGet(1));
        System.out.println(atomicLongArray.get(1));
    }
}
