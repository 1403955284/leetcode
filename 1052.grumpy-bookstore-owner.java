/*
 * @lc app=leetcode id=1052 lang=java
 *
 * [1052] Grumpy Bookstore Owner
 */

// @lc code=start
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            sum += grumpy[i] == 0 ? customers[i] : 0;
        }
        int left = 0;
        int right = 0;
        while (right < grumpy.length) {
            if (right - left + 1 <= X) {
                sum += grumpy[right] == 1 ? customers[right] : 0;
                ans = Math.max(ans, sum);
                right++;
            } else {
                if (grumpy[left] == 1) {
                    sum -= customers[left];
                }
                left++;
            }
        }
        return ans;
    }
}
// @lc code=end
