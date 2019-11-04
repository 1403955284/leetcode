import java.util.Stack;

/*
 * @lc app=leetcode id=456 lang=java
 *
 * [456] 132 Pattern
 */

// @lc code=start
class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums==null||nums.length<3){
            return false;
        }
        // 存放最大的数
        Stack<Integer> stack = new Stack<>();
        // 存放第二大的数
        int second = Integer.MIN_VALUE;
        // second总是从栈中获取的，可以保证在原序列中，second一定是排在目前记录的最大值的后面
        for (int i = nums.length-1; i >= 0; i--) {
            if (nums[i] < second) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                second = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
// @lc code=end
