import java.util.Stack;

/*
 * @lc app=leetcode id=768 lang=java
 *
 * [768] Max Chunks To Make Sorted II
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        // // 当 当前遍历过得元素中的最大值max，小于或等于后面所有没遍历过的元素，则当前所有遍历过的元素就是一个子划分。
        // int ans = 0;
        // int curMax = Integer.MIN_VALUE;
        // for(int i = 0;i<arr.length;i++){
        //     curMax = Math.max(curMax, arr[i]);
        //     boolean flag = true;
        //     for(int j = i+1;j<arr.length&&flag;j++){
        //         if(arr[j]<curMax){
        //             flag = false;
        //         }
        //     }
        //     if(flag){
        //         ans++;
        //         curMax = Integer.MIN_VALUE;
        //     }
        // }
        // return ans;


        // ======================== 使用栈 =============================
        Stack<Integer> stack = new Stack<>();
        for(int cur:arr){
            if(!stack.isEmpty()&&cur<stack.peek()){
                int head = stack.pop();
                while(!stack.isEmpty()&&stack.peek()>cur){
                    stack.pop();
                }
                stack.add(head);
            }else{
                stack.add(cur);
            }
        }
        return stack.size();
    }
}
// @lc code=end

