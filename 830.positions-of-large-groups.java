import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=830 lang=java
 *
 * [830] Positions of Large Groups
 */

// @lc code=start
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        if (S.isEmpty()) {
            return ans;
        }
        Character pre = S.charAt(0);
        int start = 0;
        int length = 0;
        for (int i = 1; i < S.length(); i++) {
            Character cur = S.charAt(i);
            if (cur == pre) {
                length++;
            } else {
                if (length >= 2) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(start);
                    tmp.add(start + length);
                    ans.add(tmp);
                }
                start = i;
                pre = S.charAt(i);
                length = 0;
            }
        }
        if (length >= 2) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(start);
            tmp.add(S.length() - 1);
            ans.add(tmp);
        }
        return ans;
    }
}
// @lc code=end
