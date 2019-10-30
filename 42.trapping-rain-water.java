import java.util.Stack;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        // // ============== 利用栈来做 =================
        // int ans = 0;
        // // 存储条形矩阵的下标
        // Stack<Integer> stack = new Stack<>();
        // int current = 0;

        // while (current < height.length) {
        // while (!stack.isEmpty() && height[stack.peek()] < height[current]) {
        // int top = stack.pop();
        // if (stack.isEmpty()) {
        // break;
        // }
        // int distance = current - stack.peek() - 1;
        // int curHeight = Math.min(height[current], height[stack.peek()]) -
        // height[top];
        // ans += distance * curHeight;

        // }
        // stack.push(current++);
        // }
        // return ans;

        // ================ 利用双指针 ===================
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int left_max = Integer.MIN_VALUE;
        int right_max = Integer.MIN_VALUE;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] > left_max) {
                    left_max = height[left];
                } else {
                    ans += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                } else {
                    ans += right_max - height[right];
                }
                right--;
            }
        }
        return ans;

    }
}
// @lc code=end
