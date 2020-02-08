import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return ans;
        }
        Map<String, String> chat = new HashMap<>();
        chat.put("2", "abc");
        chat.put("3", "def");
        chat.put("4", "ghi");
        chat.put("5", "jkl");
        chat.put("6", "mno");
        chat.put("7", "pqrs");
        chat.put("8", "tuv");
        chat.put("9", "wxyz");
        bfs(new StringBuilder(), digits, chat, 0);
        return ans;
    }

    private void bfs(StringBuilder cur, String digits, Map<String, String> chat, int index) {
        if (cur.length() == digits.length()) {
            ans.add(cur.toString());
            return;
        }
        String curAdd = chat.get(digits.substring(index, index + 1));
        for (int i = 0; i < curAdd.length(); i++) {
            bfs(new StringBuilder(cur).append(curAdd.substring(i, i + 1)), digits, chat, index + 1);
        }
    }
}
// @lc code=end
