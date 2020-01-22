import java.util.Arrays;

/*
 * @lc app=leetcode id=324 lang=java
 *
 * [324] Wiggle Sort II
 */

// @lc code=start
class Solution {
    public void wiggleSort(int[] nums) {
        if(nums==null||nums.length==0||nums.length==1){
            return;
        }
        int length = nums.length;
        int[] copy = new int[length];
        for(int i = 0;i<length;i++){
            copy[i] = nums[i];
        }
        Arrays.sort(copy);
        int index = 0;
        boolean flag = true;
        int i = (length-1)/2;
        int j = length-1;
        while(index<length){
            if(flag){
                nums[index++] = copy[i--];
                flag = false;
            }else{  
                nums[index++] = copy[j--];
                flag = true;
            }
        }
    }
}
// @lc code=end

