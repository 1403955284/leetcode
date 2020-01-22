import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // // ============================ O(n^2) 5.86% ====================================
        // Map<Integer,Integer> count1 = new HashMap<>();
        // Map<Integer,Integer> count2 = new HashMap<>();
        // List<Integer> ans = new ArrayList<>();
        // for(int cur:nums1){
        //     count1.put(cur,count1.getOrDefault(cur, 0)+1);
        // }
        // for(int cur:nums2){
        //     count2.put(cur,count2.getOrDefault(cur, 0)+1);
        // }
        // for(int key:count1.keySet()){
        //     if(count2.containsKey(key)){
        //         for(int i = 0;i<Math.min(count1.get(key), count2.get(key));i++){
        //             ans.add(key);
        //         }
        //     }
        // }
        // int[] ans1 = new int[ans.size()];
        // for(int i = 0;i<ans1.length;i++){
        //     ans1[i] = ans.get(i);
        // }
        // return ans1;
        // ==================================================================

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if (nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] ans = new int[list.size()];
        for(int k = 0;k<ans.length;k++){
            ans[k] = list.get(k);
        }
        return ans;
    }
}
// @lc code=end

