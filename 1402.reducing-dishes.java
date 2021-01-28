import java.util.Arrays;

/*
 * @lc app=leetcode id=1402 lang=java
 *
 * [1402] Reducing Dishes
 */

// @lc code=start
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum = 0;
        int val = 0;
        for(int i = satisfaction.length-1;i>=0;i--){
            sum+=satisfaction[i];
            if(sum<=0){
                break;
            }
            val+=sum;
        }
        return val;
    }

}
// @lc code=end
