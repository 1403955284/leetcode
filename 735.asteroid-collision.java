import java.util.Stack;

/*
 * @lc app=leetcode id=735 lang=java
 *
 * [735] Asteroid Collision
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            if (!stack.isEmpty()&&stack.peek() == -asteroids[i]&&stack.peek()>0&&asteroids[i]<0) {
                stack.pop();
            } else if (stack.isEmpty()
                    ||(stack.peek() < 0 && asteroids[i] < 0) 
                    ||(stack.peek() > 0 && asteroids[i] > 0)
                    ||(stack.peek() < 0 && asteroids[i] > 0)) {
                stack.push(asteroids[i]);
            } else {
                int cur = asteroids[i];
                boolean flag = true;
                while (!stack.isEmpty() && stack.peek()>0) {
                    if(stack.peek() < -cur){
                        stack.pop();
                    }else if(stack.peek()==-cur){
                        stack.pop();
                        flag = false;
                        break;
                    }else{
                        break;
                    }
                }
                if (flag&&(stack.isEmpty()||stack.peek()<0)) {
                    stack.push(cur);
                }
            }
        }
        int[] ans = new int[stack.size()];
        int i = ans.length - 1;
        while (!stack.isEmpty()) {
            ans[i--] = stack.pop();
        }
        return ans;
    }
}
// @lc code=end
