package com.liuhaidongcoder.bash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * @author Liu Haidong
 * @date 20/11/16
 */
public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec("pwd");
        int code = process.waitFor();
        System.out.println(code);
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;
        String result = "";
        while ((line = input.readLine()) != null) {
           result += line;
        }
        System.out.println(result);
        if(result.contains("Demo")){
            System.out.println("sucess!");
            process.destroy();
        }
    }
}
