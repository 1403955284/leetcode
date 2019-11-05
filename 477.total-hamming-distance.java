/*
 * @lc app=leetcode id=477 lang=java
 *
 * [477] Total Hamming Distance
 */

// @lc code=start
class Solution {
    public int totalHammingDistance(int[] nums) {
        if (nums == null) {
            return 0;
        }
        // // ===================== 超时 =====================
        // int ans = 0;
        // for (int i = 0; i < nums.length-1; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         // 异或操作使得不同位上变为1
        //         ans += getNum(nums[i] ^ nums[j]);
        //     }
        // }
        // return ans;
        // // ================================================

        // ===================== 先尝试统计每一位上1出现的次数 =================
        // 出现1则它与剩下的0匹配一定成为一个不同位
        // 位运算横向考虑超时时，尝试从单个位考虑
        int ans = 0;
        int[] sum = new int[32];
        for(int i = 0;i<nums.length;i++){
            for(int j = 0;j<32;j++){
                sum[j] += nums[i]&1;
                nums[i]>>=1;
                if(nums[i]==0){
                    break;
                }
            }
        }
        for(int i = 0;i<32;i++){
            ans+=sum[i]*(nums.length-sum[i]);
        }
        return ans;
    }

    public int getNum(int cur) {
        int ans = 0;
        while (cur != 0) {
            ans += cur & 1;
            cur >>= 1;
        }
        return ans;
    }
}

// @lc code=end
