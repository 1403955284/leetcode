import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=697 lang=java
 *
 * [697] Degree of an Array
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        // ============================= 7.06% ====================================
        int[] ans = new int[] { Integer.MAX_VALUE };
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        Map<Integer, Integer> map = new HashMap<>();
        for (int cur : nums) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        queue.addAll(map.entrySet());
        int max = queue.peek().getValue();
        map.forEach((k, v) -> {
            if (v == max) {
                int left = -1;
                int right = -1;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == k) {
                        right = i;
                        if (left == -1) {
                            left = i;
                        }
                    }
                }
                ans[0] = Math.min(ans[0], right - left + 1);
            }
        });
        return ans[0];

        // // ========================== 29% ===========================
        // Map<Integer,Integer> count = new HashMap<>();
        // Map<Integer,Integer> first = new HashMap<>();
        // int degree = 0;
        // int ans = 0;
        // for(int i = 0;i<nums.length;i++){
        //     first.putIfAbsent(nums[i], i);
        //     count.put(nums[i], count.getOrDefault(nums[i],0)+1);
        //     if(degree<count.get(nums[i])){
        //         degree = count.get(nums[i]);
        //         ans = i-first.get(nums[i])+1;
        //     }else if(degree==count.get(nums[i])){
        //         ans = Math.min(ans, i-first.get(nums[i])+1);
        //     }
        // }
        // return ans;

    }
}
// @lc code=end
