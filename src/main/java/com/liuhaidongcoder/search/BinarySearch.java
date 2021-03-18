package com.liuhaidongcoder.search;

/**
 * @author Liu Haidong
 * @date 20/11/16
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 8, 16, 27, 100};
        System.out.println(binarySearch(nums, 27));
    }

    static int binarySearch(int[] nums, int target) {
        return binary(nums, 0, nums.length - 1, target);
    }

    static int binary(int[] nums, int p, int q, int target) {
        if (p > q) {
            return -1;
        }
        int mid = (p + q) >> 1;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return binary(nums, p, mid - 1, target);
        }
        if (nums[mid] < target) {
            return binary(nums, mid + 1, q, target);
        }
        return -1;
    }
}
