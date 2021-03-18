package com.liuhaidongcoder.sort;

import java.util.Arrays;

/**
 * @author Liu Haidong
 * @date 20/11/12
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        sort(nums);
        Arrays.stream(nums).forEach(num -> System.out.println(num));
    }

    static void sort(int[] nums) {
       int pos = partition(nums,0,nums.length-1);
       sort(nums,0,pos-1);
       sort(nums,pos+1,nums.length-1);

    }

    static int partition(int[] nums, int p, int q) {
        int vaule = nums[q];
        int pos = p;
        for (int i = p; i < q; i++) {
            if (nums[i] <= vaule) {
                int tmp =nums[pos];
                nums[pos] =nums[i];
                nums[i] =tmp;
                pos++;
            }
        }
        int tmp =nums[pos];
        nums[pos] =nums[q];
        nums[q] =tmp;
        return pos;
    }

    static void sort(int[] nums,int p,int q) {
        if(p >=q){
            return;
        }
        int pos = partition(nums,p,q);
        sort(nums,p,pos-1);
        sort(nums,pos+1,q);
    }
}
