import java.util.Arrays;

/*
 * @lc app=leetcode id=480 lang=java
 *
 * [480] Sliding Window Median
 */

// @lc code=start
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length-k+1];
        for(int i = 0;i<ans.length;i++){
            int[] tmp = new int[k];
            for(int j = 0;j<k&&i+j<nums.length;j++){
                tmp[j] = nums[i+j];
            }
            Arrays.sort(tmp);
            // for(int cur:tmp){
            //     System.out.println(cur);
            // }
            ans[i] = getMid(tmp);
        }
        return ans;
    }

    public double getMid(int[] nums){
        int mid = nums.length/2;
        if(nums.length%2==0){
            return ((double)(nums[mid]-nums[mid-1])/2)+(double)nums[mid-1];
        }else{
            return nums[mid];
        }
    }
}
// @lc code=end

