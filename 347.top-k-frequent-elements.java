import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 求前 k 大，用小根堆，求前 k 小，用大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int cur : nums) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        for (int cur : map.keySet()) {
            if (queue.size() < k) {
                queue.add(cur);
            } else if (map.get(cur) > map.get(queue.peek())) {
                queue.remove();
                queue.add(cur);
            }
        }
        queue.forEach(e -> ans.add(e));
        return ans;
    }
}
// @lc code=end
