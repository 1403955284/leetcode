/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        ans[0] = binarySearch1(nums, 0, nums.length ,target);
        ans[1] = binarySearch2(nums, 0, nums.length, target);
        // int index = binarySearch(nums, 0, nums.length, target);
        // if(index!=-1){
        //     ans[0] = index;
        //     for(int i = index;i<nums.length&&nums[i]==target;i++){
        //         ans[1] = i;
        //     }
        // }
        return ans;

    }

    // 找到第一个target的索引位置
    public int binarySearch1(int[] nums,int low,int high,int target){
        if(low < high){
            int mid = (low+high)>>>1;
            if(nums[mid]>=target){
                return binarySearch1(nums, low, mid, target);
            }else{
                return binarySearch1(nums, mid+1, high, target);
            }
        }
        if(low>=nums.length){
            return -1;
        }
        return nums[low]==target?low:-1;
    }


    // 找到最后一个target的索引位置
    public int binarySearch2(int[] nums,int low,int high,int target){
        if(low < high){
            int mid = ((low+high)>>>1)+1;
            if(mid<nums.length&&nums[mid]<=target){
                return binarySearch2(nums, mid, high, target);
            }else{
                return binarySearch2(nums, low, mid-1, target);
            }
            
        }
        if(low>=nums.length){
            return -1;
        }
        return nums[low]==target?low:-1;
    }
}
// @lc code=end

