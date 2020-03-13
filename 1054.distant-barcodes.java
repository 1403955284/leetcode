import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=1054 lang=java
 *
 * [1054] Distant Barcodes
 */

// @lc code=start
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[barcodes.length];
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (int cur : barcodes) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> cur : map.entrySet()) {
            queue.add(cur);
        }
        int index = 0;
        while (index < barcodes.length) {
            if (queue.size() >= 2) {
                Map.Entry<Integer, Integer> cur1 = queue.remove();
                Map.Entry<Integer, Integer> cur2 = queue.remove();
                ans[index++] = cur1.getKey();
                ans[index++] = cur2.getKey();
                cur1.setValue(cur1.getValue() - 1);
                cur2.setValue(cur2.getValue() - 1);
                if (cur1.getValue() != 0) {
                    queue.offer(cur1);
                }
                if (cur2.getValue() != 0) {
                    queue.offer(cur2);
                }
            } else {
                Map.Entry<Integer, Integer> cur1 = queue.remove();
                ans[index++] = cur1.getKey();
                cur1.setValue(cur1.getValue() - 1);
                if (cur1.getValue() != 0) {
                    queue.offer(cur1);
                }
            }
        }
        return ans;
    }
}
// @lc code=end
