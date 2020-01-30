import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=703 lang=java
 *
 * [703] Kth Largest Element in a Stream
 */

// @lc code=start
class KthLargest {
    int size;
    private PriorityQueue<Integer> q;

    public KthLargest(int k, int[] nums) {
        size = k;
        q = new PriorityQueue(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (q.size() < size) {
            q.add(val);
        } else if (q.peek() < val) {
            q.poll();
            q.add(val);
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such: KthLargest
 * obj = new KthLargest(k, nums); int param_1 = obj.add(val);
 */
// @lc code=end
