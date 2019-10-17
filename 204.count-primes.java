import java.util.Arrays;

/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        int ans = 0;
        int[] nums = new int[n];
        Arrays.fill(nums, 1);
        nums[0] = 0;
        nums[1] = 0;
        for(int i = 2;i<n;i++){
            if(nums[i]==1){
                int m = 2;
                int tmpIndex = i*m;
                while(tmpIndex<n){
                    nums[tmpIndex] = 0;
                    m++;
                    tmpIndex = i*m;
                }
            }
        }
        for(int i = 2;i<n;i++){
            if(nums[i] == 1){
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

