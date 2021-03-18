package com.liuhaidongcoder.sort;

/**
 * @author Liu Haidong
 * @date 20/11/11
 */
public class BubbleSort {
    public static void sort(int[] nums){
        int n = nums.length;
        int tmp;
        for(int i=1;i<=n-1;i++){
            for (int j=0;j<n-i;j++){
                if(nums[j] > nums[j+1]){
                    tmp = nums[j];
                    nums[j] =nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }
}
