import java.util.Arrays;

/*
 * @lc app=leetcode id=389 lang=java
 *
 * [389] Find the Difference
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        int length = s.length();
        int i = 0;
        for(i = 0;i<length;i++){
            if(s1[i]!=s2[i]){
                break;
            }
        }
        return s2[i];
        
    }
}
// @lc code=end

