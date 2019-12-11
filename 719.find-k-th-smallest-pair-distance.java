import java.util.Arrays;

/*
 * @lc app=leetcode id=719 lang=java
 *
 * [719] Find K-th Smallest Pair Distance
 */

// @lc code=start
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        // ================== 暴力 5% ==========================
        int ans = 0;
        int[] count = new int[1000000];
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                int cur = Math.abs(nums[i]-nums[j]);
                count[cur]++;
            }
        }
        for(int i = 0;i<count.length;i++){
            int curCount = count[i];
            k-=curCount;
            if(k<=0){
                ans = i;
                break;
            }
        }
        return ans;



    }
}
// @lc code=end

