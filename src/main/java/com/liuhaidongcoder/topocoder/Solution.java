package com.liuhaidongcoder.topocoder;


import java.io.*;

/**
 * @author Liu Haidong
 * @date 20/12/23
 */
public class Solution {
    static class Result{
        private String user1;
        private String user2;
        private double result;

        public Result( String user1, String user2,double result) {
            this.result = result;
            this.user1 = user1;
            this.user2 = user2;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "user1='" + user1 + '\'' +
                    ", user2='" + user2 + '\'' +
                    ", result=" + result +
                    '}';
        }
    }
    public static void main(String[] args) {
        //构造小顶堆
        Result[] result = new Result[5];
        int count =0;
        try(BufferedReader fileReader1 = new BufferedReader(new FileReader("/Users/liuhaidong/IdeaProjects/Demo/src/main/java/com/liuhaidongcoder/topocoder/seed.txt"))){
            String line1 = null;
            while((line1=fileReader1.readLine())!=null){
                try(BufferedReader fileReader2 = new BufferedReader(new FileReader("/Users/liuhaidong/IdeaProjects/Demo/src/main/java/com/liuhaidongcoder/topocoder/all.txt"))){
                    String line2 = null;
                    while((line2=fileReader2.readLine())!=null){
                        if(count != 5){
                            result[count] = calCos(line1,line2);
                            count ++;
                        }else{
                            heapify(result,4);
                            Result tmp = calCos(line1,line2);
                            if(tmp.result > result[0].result){
                                result[0] = tmp;
                                heapify(result,4);
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //堆排序
        heapSort(result);
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter("/Users/liuhaidong/IdeaProjects/Demo/src/main/java/com/liuhaidongcoder/topocoder/result.txt"),1073741824)){
            for(Result res : result){
                fileWriter.write(res.user2);
                fileWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static void heapSort(Result[] result) {
        int pos = result.length -1;
        while(pos-1 >= 0){
            heapSort(result,pos);
            pos--;
        }

    }
    static void heapSort(Result[] result,int pos) {
        Result tmp = result[0];
        result[0] = result[pos];
        result[pos] = tmp;
        heapify(result,pos-1);

    }

    static void heapify(Result[] result,int pos) {
        for(int i = 0;i <= pos;i++){
            while(i/2 >=0 && result[i].result < result[i/2].result){
                Result tmp = result[i/2];
                result[i/2] = result[i];
                result[i] = tmp;
                i = i/2;
            }
        }

    }
    static Result calCos(String data1,String data2){
        String[] strArays1 = data1.split(",");
        String[] strArays2 = data2.split(",");
        double sum = 0 ;
        for(int i=1;i< 5;i++){
            sum += Double.valueOf(strArays1[i]) * Double.valueOf(strArays2[i]);
            //sum = sum.BigDecimal.valueOf(Double.valueOf(strArays1[i])).multiply(BigDecimal.valueOf(Double.valueOf(strArays2[i])));
        }
        double sum1 = 0;
        double sum2 = 0;
        for (int i=1;i<5;i++){
            sum1 += Math.pow(Double.valueOf(strArays1[i]),2);
            sum2 += Math.pow(Double.valueOf(strArays2[i]),2);
        }
        Result result = new Result(strArays1[0],strArays2[0],sum/(Math.sqrt(sum1)*Math.sqrt(sum2)));
        return result;
    }
}
