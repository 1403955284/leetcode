import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=784 lang=java
 *
 * [784] Letter Case Permutation
 */

// @lc code=start
class Solution {
    private List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {
        dfs(new StringBuilder(), S, 0);
        return ans;
    }

    public void dfs(StringBuilder tmp, String S, int index) {
        // System.out.println("index:" + index + " String:" + tmp.toString());
        if (index == S.length()) {
            ans.add(tmp.toString());
            return;
        }
        Character curChar = S.charAt(index);

        if (curChar >= '0' && curChar <= '9') {
            StringBuilder newString1 = new StringBuilder(tmp);
            newString1.append(curChar);
            dfs(newString1, S, index + 1);
        } else {
            StringBuilder newString1 = new StringBuilder(tmp);
            newString1.append(Character.toLowerCase(curChar));
            dfs(newString1, S, index + 1);
            StringBuilder newString2 = new StringBuilder(tmp);
            newString2.append(Character.toUpperCase(curChar));
            dfs(newString2, S, index + 1);
        }

    }
}
// @lc code=end
