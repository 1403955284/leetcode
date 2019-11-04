import java.util.Arrays;

/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        StringBuilder ans = new StringBuilder();
        int[] times = new int[128];
        for (char cur : s.toCharArray()) {
            times[cur]++;
        }
        for (int i = s.length(); i >= 1; i--) {
            for (int j = 0; j < times.length; j++) {
                if (times[j] == i) {
                    while (times[j] != 0) {
                        ans.append((char) j);
                        times[j]--;
                    }
                }
            }
        }
        return ans.toString();
    }
}
// @lc code=end
