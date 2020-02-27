import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (o1, o2) -> o2[0] * o2[0] + o2[1] * o2[1] - (o1[0] * o1[0] + o1[1] * o1[1]));
        for (int[] cur : points) {
            if (queue.size() < K) {
                queue.offer(cur);
            } else if (getSum(cur) < getSum(queue.peek())) {
                queue.poll();
                queue.offer(cur);
            }
        }
        int[][] ans = new int[K][2];
        int index = 0;
        while (!queue.isEmpty()) {
            ans[index++] = queue.poll();
        }
        return ans;

    }

    public int getSum(int[] data) {
        return data[0] * data[0] + data[1] * data[1];
    }
}
// @lc code=end
