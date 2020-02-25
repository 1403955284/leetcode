import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=967 lang=java
 *
 * [967] Numbers With Same Consecutive Differences
 */

// @lc code=start
class Solution {
    private List<String> list = new ArrayList<>();

    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 0) {
            return new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        }
        if (N == 1) {
            return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        }
        for (int i = 1; i <= 9; i++) {
            dfs(new StringBuilder().append(i), N, K, i);
        }
        int[] ans = new int[list.size()];
        int index = 0;
        for (String tmp : list) {
            ans[index++] = Integer.valueOf(tmp);
        }
        return ans;
    }

    public void dfs(StringBuilder tmp, int N, int K, int curNum) {
        if (tmp.length() == N) {
            list.add(tmp.toString());
            return;
        }
        if (K == 0) {
            dfs(new StringBuilder(tmp).append(curNum), N, K, curNum);
        } else {
            if (curNum - K >= 0 && curNum - K <= 9) {
                dfs(new StringBuilder(tmp).append(curNum - K), N, K, curNum - K);
            }
            if (curNum + K >= 0 && curNum + K <= 9) {
                dfs(new StringBuilder(tmp).append(curNum + K), N, K, curNum + K);
            }
        }
    }
}
// @lc code=end
