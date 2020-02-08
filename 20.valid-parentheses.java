import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (Character cur : s.toCharArray()) {
            if (cur == '(') {
                stack.push(')');
            } else if (cur == '[') {
                stack.push(']');
            } else if (cur == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || cur != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end
