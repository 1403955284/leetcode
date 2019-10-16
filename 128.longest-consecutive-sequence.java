import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        /**
         * 测试用例有中有重复数字，得先去重。
         */
        Set<Integer> num_set = new HashSet<>();
        for (int n : nums)
            num_set.add(n);
        int res = 0;
        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int tmp = 1;
                while (num_set.contains(num + 1)) {
                    tmp++;
                    num++;
                }
                res = Math.max(res, tmp);
            }
        }
        return res;

    }
}
// @lc code=end
