/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    public int search(int[] nums,int target,int low,int high){
        if(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<=target){
                return search(nums, target, mid+1, high);
            }else{
                return search(nums, target, low, mid-1);
            }
        }
        return low;
    }
}
// @lc code=end

