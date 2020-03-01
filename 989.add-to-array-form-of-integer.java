import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=989 lang=java
 *
 * [989] Add to Array-Form of Integer
 */

// @lc code=start
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new ArrayList<>();
        int tmp = K;
        for (int i = A.length - 1; i >= 0; i--) {
            tmp = tmp + A[i];
            ans.add(tmp % 10);
            tmp /= 10;
        }
        while (tmp != 0) {
            ans.add(tmp % 10);
            tmp /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }
}
// @lc code=end
