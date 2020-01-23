import java.util.Arrays;

/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        int ans = 0;
        for(int cur:g){
            for(;j<s.length;){
                if(cur<=s[j]){
                    ans++;
                    j++;
                    break;
                }
                j++;
            }
        }
        return ans;
    }
}
// @lc code=end

