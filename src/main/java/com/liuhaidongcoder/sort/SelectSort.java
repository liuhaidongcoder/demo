package com.liuhaidongcoder.sort;

import java.util.Arrays;

/**
 * @author Liu Haidong
 * @date 20/11/11
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        sort(nums);
        Arrays.stream(nums).forEach(num -> System.out.println(num));
    }

    public static void sort(int[] nums) {
        int n = nums.length;
        int min;
        for (int i = 0; i < n - 1; i++) {
            min = nums[i];
            int index = -1;
            for (int j = i; j < n; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            if (index != -1) {
                int tmp = nums[i];
                nums[i] = min;
                nums[index] = tmp;
            }
        }
    }
}
