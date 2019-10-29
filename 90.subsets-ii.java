import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        List<Integer> init1 = new ArrayList<>();
        init1.add(nums[0]);
        ans.add(init);
        ans.add(init1);
        for(int i = 1;i<nums.length;i++){
            int curLength = ans.size();
            for(int j = 0;j<curLength;j++){
                List<Integer> tmp = new ArrayList<>(ans.get(j));
                tmp.add(nums[i]);
                Collections.sort(tmp);
                if(!ans.contains(tmp)){
                    ans.add(tmp);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

