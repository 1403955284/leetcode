import java.util.Arrays;

/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        int[] record = new int[26];
        Arrays.fill(record, -1);
        for(int i = 0;i<s.length();i++){
            Character cur = s.charAt(i);
            if(record[cur-'a']==-1){
                record[cur-'a'] = i;
            }else{
                record[cur-'a'] = Integer.MAX_VALUE;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<26;i++){
            if(record[i]!=-1&&record[i]!=Integer.MAX_VALUE){
                ans = Math.min(ans, record[i]);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
// @lc code=end

