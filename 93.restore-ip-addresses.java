import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

// @lc code=start
class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, new ArrayList<>());
        return ans;
    }

    public void backtrack(String s, int index, List<String> list) {
        if (index == s.length() && list.size() == 4) {
            StringBuilder tmp = new StringBuilder().append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                tmp.append(".").append(list.get(i));
            }
            ans.add(tmp.toString());
            return;
        }
        if (index < s.length() && list.size() < 4) {
            for (int i = index + 1; i <= s.length() && i - index <= 3; i++) {
                int cur = Integer.valueOf(s.substring(index, i));
                String curStr = s.substring(index, i);
                if (cur >= 0 && cur <= 255
                        && (curStr.length() == 1 || (curStr.length() > 1 && !curStr.startsWith("0")))) {
                    list.add(curStr);
                    backtrack(s, i, list);
                    list.remove(list.size() - 1);
                }
            }
        }

    }
}
// @lc code=end
