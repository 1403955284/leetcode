import java.util.Stack;

/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> str = new Stack<>();
        char[] charStr = s.toCharArray();
        for (int i = 0; i < charStr.length; i++) {
            if (charStr[i] >= '0' && charStr[i] <= '9') {
                int j = i;
                while (charStr[j] >= '0' && charStr[j] <= '9') {
                    j++;
                }
                nums.push(Integer.valueOf(s.substring(i, j)));
                i = j - 1;
            } else {
                str.push(s.substring(i, i + 1));
                if (str.peek().equals("]")) {
                    int times = nums.pop();
                    str.pop();
                    String tmp = new String();
                    while (!str.peek().equals("[")) {
                        tmp += str.pop();
                    }
                    str.pop();
                    String cur = new String();
                    for (int k = 0; k < times; k++) {
                        cur += tmp;
                    }
                    str.push(cur);
                }
            }
        }
        String ans = new String();
        while (!str.isEmpty()) {
            ans += str.pop();
        }
        return new StringBuilder(ans).reverse().toString();
    }
}
// @lc code=end
