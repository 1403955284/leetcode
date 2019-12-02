import java.util.Arrays;

/*
 * @lc app=leetcode id=645 lang=java
 *
 * [645] Set Mismatch
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int[] save = new int[nums.length+1];
        for(int cur:nums){
            save[cur]++;
        }
        for(int i = 1;i<save.length;i++){
            if(save[i]==0){
                ans[1] = i;
            }
            if(save[i]==2){
                ans[0] = i;
            }
        }
        return ans;
        
    }
}
// @lc code=end

