/*
 * @lc app=leetcode id=915 lang=java
 *
 * [915] Partition Array into Disjoint Intervals
 */

// @lc code=start
class Solution {
    public int partitionDisjoint(int[] A) {
        int leftMax = A[0], curMax = A[0], index = 0;
        for (int i = 1; i < A.length; i++) {
            if (leftMax < A[i]) {
                curMax = Math.max(curMax, A[i]);
            } else if (leftMax > A[i]) {
                index = i;
                leftMax = curMax;
            }
        }
        return index + 1;
    }
}
// @lc code=end
