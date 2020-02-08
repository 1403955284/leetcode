import java.util.Arrays;

/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        /**
         * 将原数组从中一分为二，查看nums[mid]和nums[left]及nums[right]的大小
         * 如果nums[left]<=nums[mid],说明原数组左半部分是升序的，可以利用二分搜索在这部分寻找target
         * 如果nums[right]>=nums[mid],说明原数组右半部分是升序的，可以利用二分搜索在这部分寻找target
         * 如果在升序部分没找到，就在非严格升序部分继续该过程直到left>right，说明原数组中没有target
         */

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                int index = Arrays.binarySearch(nums, left, mid + 1, target);
                if (index >= 0) {
                    return index;
                } else {
                    left = mid + 1;
                }
            } else {
                int index = Arrays.binarySearch(nums, mid, right + 1, target);
                if (index >= 0) {
                    return index;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
