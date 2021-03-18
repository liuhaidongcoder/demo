package com.liuhaidongcoder.sort;

import java.util.Arrays;

/**
 * @author Liu Haidong
 * @date 20/11/27
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[]{ 1,2,5,4,2};
        heapify(nums);
        for(int i : nums){
            System.out.println(i);
        }

    }

    public static void heapify(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            while(i/2 >=0 && nums[i] > nums[i/2]){
                int tmp = nums[i/2];
                nums[i/2] = nums[i];
                nums[i] = tmp;
                i = i/2;
            }
        }
        int pos = nums.length - 1;
        while(pos > 0){
            int tmp = nums[0];
            nums[0] = nums[pos];
            nums[pos] = tmp;
        }

    }
}
