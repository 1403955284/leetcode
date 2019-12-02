import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=658 lang=java
 *
 * [658] Find K Closest Elements
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new LinkedList<>();
        int index = -1;
        int minDis = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (Math.abs(arr[i] - x) <= minDis) {
                minDis = Math.abs(arr[i] - x);
                index = i;
            }
        }
        ans.add(arr[index]);
        int left = index - 1;
        int right = index + 1;
        for (int i = 1; i < k;) {
            if (left < 0) {
                ans.add(arr[right++]);
                i++;
            } else if (right >= arr.length) {
                ans.add(arr[left--]);
                i++;
            } else {
                if (Math.abs(x - arr[left]) <= Math.abs(x - arr[right])) {
                    ans.add(arr[left--]);
                } else {
                    ans.add(arr[right++]);
                }
                i++;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
// @lc code=end
