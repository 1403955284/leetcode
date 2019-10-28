import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Increasing Subsequences
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new LinkedList<>();
    private Set<List<Integer>> setAns = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> init = new LinkedList<>();
            init.add(nums[i]);
            helper(nums, i + 1, init);
        }
        setAns.forEach(e -> ans.add(e));
        return ans;
    }

    public void helper(int[] nums, int index, List<Integer> cur) {
        if (cur.size() >= 2) {
            setAns.add(cur);
        }
        if (index == nums.length) {
            return;
        }

        int tmp = nums[index];
        if (tmp >= cur.get(cur.size() - 1)) {
            List<Integer> new_cur = new LinkedList<>(cur);
            new_cur.add(tmp);
            helper(nums, index + 1, new_cur);
            helper(nums, index + 1, cur);
        } else {
            helper(nums, index + 1, cur);
        }

    }
}
// @lc code=end
