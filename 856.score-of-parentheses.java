import java.util.Stack;

/*
 * @lc app=leetcode id=856 lang=java
 *
 * [856] Score of Parentheses
 */

// @lc code=start
class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for(Character cur:S.toCharArray()){
            if(cur=='('){
                stack.push(cur);
            }else{
                int curSum = 0;
                while(stack.peek()!='('){
                    curSum+=(stack.pop()-'0');
                }
                stack.pop();
                if(curSum==0){
                    stack.push('1');
                }else{
                    stack.push((char)(curSum*2+'0'));
                }

            }
        }
        while(!stack.isEmpty()){
            ans+=stack.pop()-'0';
        }
        return ans;
    }
}
// @lc code=end

