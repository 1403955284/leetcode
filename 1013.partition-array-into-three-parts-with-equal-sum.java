/*
 * @lc app=leetcode id=1013 lang=java
 *
 * [1013] Partition Array Into Three Parts With Equal Sum
 */

// @lc code=start
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int cur : A) {
            sum += cur;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;
        int index = 0;
        int curSum = 0;
        int count = 0;
        while (index < A.length) {
            curSum += A[index];
            index++;
            if (curSum == target) {
                count++;
                curSum = 0;
            }
        }
        return index == A.length && count == 3;
    }
}
// @lc code=end
