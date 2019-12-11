import java.util.LinkedList;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums == null) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            while (!queue.isEmpty() && curNum >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if (i - queue.getFirst() + 1 > k) {
                queue.removeFirst();
            }
            if (i + 1 >= k) {
                ans[index++] = nums[queue.getFirst()];
            }

        }
        return ans;
    }
}
// @lc code=end

