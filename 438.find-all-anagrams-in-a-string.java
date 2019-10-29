import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] test = new int[26];
        int length = p.length();
        List<Integer> ans = new LinkedList<>();
        for (char cur : p.toCharArray()) {
            test[cur - 'a']++;
        }
        for (int i = 0; i <= s.length() - length; i++) {
            String str = s.substring(i, i + length);
            if (isSame(str, test)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isSame(String str, int[] test) {
        int[] tmp = new int[26];
        for (char cur : str.toCharArray()) {
            tmp[cur - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (test[i] != tmp[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
