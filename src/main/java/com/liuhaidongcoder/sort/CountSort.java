package com.liuhaidongcoder.sort;

import java.util.Arrays;

/**
 * @author Liu Haidong
 * @date 20/11/13
 */
public class CountSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 8, 16, 27, 20, 100};
        sort(nums);
    }
    public static void sort(int[] nums) {
        int[] bucket = new int[150];
        for(int i=0;i < nums.length;i++){
            if(bucket[nums[i]] == 0){
                bucket[nums[i]] = 1;
            }else{
                bucket[nums[i]] = bucket[nums[i]] +1;
            }
        }
        int[] count = new int[bucket.length];
        for(int i =0;i<bucket.length;i++){
             for(int j=0;j <=i;j++ ){
                 count[i] = count[i] + bucket[j];
             }
        }
        int[] tmp = new int[nums.length];
        for(int i=0;i < nums.length;i++){
          int pos = count[nums[i]];
          tmp[pos-1] = nums[i];
          count[nums[i]] = count[nums[i]] -1;
        }

        Arrays.stream(tmp).forEach(num -> System.out.println(num));

    }
}
