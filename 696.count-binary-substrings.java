import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=696 lang=java
 *
 * [696] Count Binary Substrings
 */

// @lc code=start
class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> count = new ArrayList<>();
        int ans = 0;
        for(int i = 0;i<s.length();){
            int curNum = s.charAt(i);
            int curCount = 0;
            while(i<s.length()&&s.charAt(i)==curNum){
                curCount++;
                i++;
            }
            count.add(curCount);
        }
        for(int i = 0;i<count.size()-1;i++){
            ans+=Math.min(count.get(i), count.get(i+1));
        }
        return ans;
    }
}
// @lc code=end

