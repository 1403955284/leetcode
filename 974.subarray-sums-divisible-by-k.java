import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=974 lang=java
 *
 * [974] Subarray Sums Divisible by K
 */

// @lc code=start
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        // 记录余数及其出现次数
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int cur : A) {
            sum += cur;
            map.put(((sum % K) + K) % K, map.getOrDefault(((sum % K) + K) % K, 0) + 1);
        }
        for (int key : map.keySet()) {
            // 特殊情况是，本身余数就是0，则除了计算本身之外，还要考虑余数0与余数0相互组合。
            if (key == 0) {
                ans += map.get(key);
                ans += getSum(map.get(key));
            } else if (map.get(key) >= 2) {
                ans += getSum(map.get(key));
            }
        }
        return ans;
    }

    // 有两个余数相同的，大数减去小数就可以使余数为0
    /**
     * 从左向右累计sum。每加一个数往map存放其余数，看看最后同样余数的一共有多少个，这些同样余数的 两两相互组合就可以构成余数为0的连续子数组。
     * 
     * @param n
     * @return
     */
    public int getSum(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return getSum(n - 1) + n - 1;
    }
}
// @lc code=end
