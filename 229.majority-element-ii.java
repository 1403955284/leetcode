import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        int target = nums.length/3+1;
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if(map.get(nums[i])>=target){
                ans.add(nums[i]);
            }
        }
        return new ArrayList<>(ans);
    }
}
// @lc code=end

