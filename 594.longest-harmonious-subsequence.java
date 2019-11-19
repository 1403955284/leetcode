import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=594 lang=java
 *
 * [594] Longest Harmonious Subsequence
 */

// @lc code=start
class Solution {
    public int findLHS(int[] nums) {
        int[] ans = new int[]{0};
        Map<Integer,Integer> map = new HashMap<>();
        for(int cur:nums){
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur)+1);
            }else{
                map.put(cur, 1);
            }
        }
        map.forEach((e,v)->{
            if(map.containsKey(e+1)){
                ans[0] = Math.max(ans[0], v+map.get(e+1));
            }
        });
        return ans[0];
    }
}
// @lc code=end

