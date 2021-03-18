package com.liuhaidongcoder.sort;

/**
 * @author Liu Haidong
 * @date 20/11/14
 *
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] nums = new int[]{100, 50, 1};
        radixSort(nums);
    }
    public static void radixSort(int[] nums){
        int max =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int keysNum = 0;
        while(max>0){
            max /= 10;
            keysNum++;
        }
        System.out.println(keysNum);

    }
}
