/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public int binarySearch(int[] nums,int low,int high,int target){
        if(low<=high){
            int mid = (low+high)>>>1;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                return binarySearch(nums, mid+1, high, target);
            }else{
                return binarySearch(nums, low, mid-1, target);
            }
        }
        return -1;
    }
}
// @lc code=end

