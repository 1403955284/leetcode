import java.util.Stack;

/*
 * @lc app=leetcode id=1047 lang=java
 *
 * [1047] Remove All Adjacent Duplicates In String
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (char cur : S.toCharArray()) {
            boolean flag = true;
            while (!stack.isEmpty() && stack.peek() == cur) {
                stack.pop();
                flag = false;
            }
            if (flag) {
                stack.push(cur);
            }
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
// @lc code=end
