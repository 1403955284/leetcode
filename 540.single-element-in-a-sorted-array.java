/*
 * @lc app=leetcode id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // // 位运算 O(n)
        // int ans = 0;
        // for(int cur:nums){
        //     ans^=cur;
        // }
        // return ans;



        // 二分查找 O(logN)
        int l=0,r=nums.length-1;
       while(l<r){
           int h=(r+l)/2;
           if(h%2==1){
               if(nums[h]==nums[h+1])
                   r=h-1;
               else
                   l=h+1;
           }else{
               if(nums[h]==nums[h+1])
                   l=h+2;
               else
                   r=h;
           }
       }
        return nums[l];
    }
}
// @lc code=end

