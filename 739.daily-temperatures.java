/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        for(int i = 0;i<T.length;i++){
            int cur = 0;
            for(int j = i+1;j<T.length;j++){
                cur++;
                if(T[j]>T[i]){
                    ans[i] = cur;
                    break;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

