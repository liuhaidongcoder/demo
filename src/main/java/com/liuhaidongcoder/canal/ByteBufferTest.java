package com.liuhaidongcoder.canal;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;

/**
 * @author Liu Haidong
 * @date 21/1/11
 */
public class ByteBufferTest {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte bt = 1;
        byteBuffer.put(bt);
        byteBuffer.put(bt);

        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println("position :" + byteBuffer.position());
        byteBuffer.mark();
        byteBuffer.position(10);
        byteBuffer.put(bt);
        //是10
        System.out.println(byteBuffer.position());
        byteBuffer.reset();
        System.out.println(byteBuffer.position());

        byteBuffer.flip();


        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());


        IntBuffer intBuffer = IntBuffer.allocate(1);
        intBuffer.put(10000);
        intBuffer.flip();
        System.out.println(intBuffer.get());

    }
}
