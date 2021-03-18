package com.liuhaidongcoder.sort;

/**
 * @author Liu Haidong
 * @date 20/11/12
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        System.out.println(find(nums,2));

    }
    public static int find(int[] nums,int k) {
        int pos = partition(nums,0,nums.length-1);
        int result = -1;
        if(pos+1 == k){
            result = nums[pos];
        }
        if(k > pos+1){
            result =findK(nums,pos+1,nums.length-1,k);
        }
        if(k < pos+1){
            result =findK(nums,0,pos-1,k);
        }
        return result;
    }
    public static int findK(int[] nums,int p,int q,int k){
        int pos = partition(nums,p,q);
        int result = -1;
        if(pos+1 == k){
            result = nums[pos];
        }
        if(k > pos+1){
            result =findK(nums,pos+1,q,k);
        }
        if(k < pos+1){
            result =findK(nums,p,pos-1,k);
        }
        return result;
    }
    public static int partition(int[] nums,int p, int q){
        int value = nums[q];
        int pos =p;
        for(int i=p;i<q;i++){
            if(nums[i] > value){
                int tmp =nums[pos];
                nums[pos++] = nums[i];
                nums[i] = tmp;
            }
        }
        int tmp =nums[pos];
        nums[pos] = nums[q];
        nums[q] = tmp;
        return pos;
    }
}
