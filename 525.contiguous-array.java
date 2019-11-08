import java.util.HashMap;

/*
 * @lc app=leetcode id=525 lang=java
 *
 * [525] Contiguous Array
 */

// @lc code=start
class Solution {
    public int findMaxLength(int[] nums) {
        // // ============== 动态规划做法，超时 ===================
        // // 从i到j的连续序列中，1比0多的个数
        // int[][] dp = new int[nums.length][nums.length];
        // int ans = 0;
        // for(int i = 0;i<nums.length;i++){
        //     dp[i][i] = nums[i]==0?-1:1;
        // }

        // for(int i = nums.length-1;i>=0;i--){
        //     for(int j = i+1;j<nums.length;j++){
        //         dp[i][j] = dp[i][j-1]+(nums[j]==1?1:-1);
        //         if(dp[i][j]==0){
        //             ans= Math.max(ans, (j-i+1));
        //         }
        //     }
        // }
        // return ans;
        // // ==================================================



        // ========================== 答案做法 ==========================================
        // 参考:https://leetcode-cn.com/problems/contiguous-array/solution/lian-xu-shu-zu-by-leetcode/

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        // 记录当前遍历到当前点，1比0多的个数
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            int cur = nums[i];
            count+=cur==1?1:-1;
            if(map.containsKey(count)){
                maxLength = Math.max(maxLength, i-map.get(count));
            }else{
                map.put(count, i);
            }
        }
        return maxLength;
    }
}
// @lc code=end

