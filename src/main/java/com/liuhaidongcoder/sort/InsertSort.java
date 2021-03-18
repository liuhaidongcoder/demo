package com.liuhaidongcoder.sort;

/**
 * @author Liu Haidong
 * @date 20/11/11
 */
public class InsertSort {
    public static void sort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int value = nums[i];
            for (; j >= 0; j--) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                }else {
                    break;
                }
            }
            nums[j+1] = value;
        }
    }
}
