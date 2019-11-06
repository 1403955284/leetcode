import java.util.Arrays;

/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);

        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            count += j - mid - 1;
        }
        // // merge超时
        // merge(nums, start, mid, end);
        Arrays.sort(nums, start, end + 1);
        return count;
    }

    public void merge(int[] nums, int start, int mid, int end) {
        int[] helper = new int[nums.length];
        for (int i = start; i <= end; i++) {
            helper[i] = nums[i];
        }
        int l = start;
        int r = mid + 1;
        int index = start;
        while (l <= mid || r <= end) {
            if (l > mid || (r <= end && helper[l] >= helper[r])) {
                nums[index++] = helper[r++];
            } else {
                nums[index++] = helper[l++];
            }
        }
    }

}
// @lc code=end
