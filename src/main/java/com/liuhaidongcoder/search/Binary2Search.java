package com.liuhaidongcoder.search;

import java.util.Random;

/**
 * @author Liu Haidong
 * @date 20/11/18
 */
public class Binary2Search {
    public static void main(String[] args) {
        System.out.println((new Random ()).nextFloat());
    }

    static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] > target) {
                high = mid - 1;
            }
            if (nums[mid] < target) {
                low = low + 1;
            }
            if (nums[mid] == target) {
                if (mid == nums.length - 1) {
                    return mid;
                }
                if (nums[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
