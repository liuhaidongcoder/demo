package com.liuhaidongcoder.sort;

import java.util.Arrays;

/**
 * @author Liu Haidong
 * @date 20/11/11
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2};
        sort(nums);
        Arrays.stream(nums).forEach(num -> System.out.println(num));

    }
    public static void sort(int[] nums) {
        int n = nums.length;
        mergeSort(nums,0,n-1);
    }
    public static void mergeSort(int[] nums,int p,int q){
        if(p>=q){
            return;
        }
        int r = (p+q)/2;
        mergeSort(nums,p,r);
        mergeSort(nums,r+1,q);
        merge(nums,p,r,r+1,q);
    }
    public static void merge(int[] nums,int p,int r,int t,int q){
         int[] tmp = new int[q-p+1];
         int tm = 0;
         int i = p;
         int j = t;
         while(i <=r && j <=q){
             if(nums[i] < nums[j]){
                 tmp[tm++] =nums[i++];
             }else{
                 tmp[tm++] = nums[j++];
             }
         }
         if(i <=r){
            for(;i<=r;i++){
                tmp[tm++] = nums[i];
            }
         }
         if(j <=q){
             for(;j<=p;j++){
                 tmp[tm++] = nums[j];
             }
         }
        for(int l=0;l <tmp.length;l ++){
            nums[p] = tmp[l];
            p++;
        }
    }
}
