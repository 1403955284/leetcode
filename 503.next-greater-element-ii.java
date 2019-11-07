import java.util.Stack;

/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        // // ==================== 暴力破解 ===================
        // for(int i = 0;i<nums.length;i++){
        //     for(int j = (i+1+nums.length)%nums.length;;j = (j+1+nums.length)%nums.length){
        //         if(j==i){
        //             ans[i] = -1;
        //             break;
        //         }
        //         if(nums[j]>nums[i]){
        //             ans[i] = nums[j];
        //             break;
        //         }
        //     }
        // }

        // ================ 利用栈 ================
        // 45ms beats25%
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for(int i = 2*n-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()<=nums[i%n]){
                stack.pop();
            }
            ans[i%n] = stack.isEmpty()?-1:stack.peek();
            // System.out.println("ans["+(i%n)+"]:"+ans[i%n]);
            stack.push(nums[i%n]);
        }
        return ans;
    }
}
// @lc code=end

