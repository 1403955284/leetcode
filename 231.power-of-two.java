/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        boolean flag = true;
        while(n!=1&&flag){
            if(n%2!=0){
                flag = false;
            }
            n/=2;
        }
        return flag;
    }
}
// @lc code=end

