import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=842 lang=java
 *
 * [842] Split Array into Fibonacci Sequence
 */

// @lc code=start
class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        return backtrack(S, ans, 0) ? ans : new ArrayList<>();
    }

    public boolean backtrack(String S, List<Integer> ans, int start) {
        if (ans.size() >= 3) {
            int num = ans.size();
            if (ans.get(num - 1) != ans.get(num - 2) + ans.get(num - 3)) {
                return false;
            }
        }
        if (start == S.length() && ans.size() >= 3) {
            return true;
        }
        for (int i = start + 1; i <= S.length(); i++) {
            String tmp = S.substring(start, i);
            if (tmp.charAt(0) == '0' && !"0".equals(tmp)) {
                break;
            }
            long num = Long.parseLong(tmp);
            if (num > Integer.MAX_VALUE) {
                break;
            }
            ans.add((int) num);
            if (backtrack(S, ans, i)) {
                return true;
            }
            ans.remove(ans.size() - 1);
        }
        return false;
    }
}
// @lc code=end
