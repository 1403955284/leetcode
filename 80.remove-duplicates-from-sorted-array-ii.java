/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 || nums.length == 2) {
            return nums.length;
        }
        int flag = nums[0] - 1;
        int prev = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                count++;
                if (count > 2) {
                    nums[i] = flag;
                }
                continue;
            }
            if (nums[i] != prev) {
                prev = nums[i];
                count = 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        int p1 = -1;
        int p2 = -1;

        // 找到第一个被标记为flag的数字的下标
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == flag) {
                p1 = i;
                break;
            }
        }
        if (p1 == nums.length - 1) {
            return p1;
        }
        if (p1 == -1) {
            return nums.length;
        }
        // 找到在p1后第一个需要被保留的数字的下标
        for (int i = p1; i < nums.length; i++) {
            if (nums[i] != flag) {
                p2 = i;
                break;
            }
        }
        if (p2 == -1) {
            return p1;
        }

        // 不断交换p1和p2所对应的数字
        while (p1 < nums.length && p2 < nums.length) {
            if (nums[p2] != flag) {
                nums[p1] = nums[p2];
                nums[p2] = flag;
                p1++;
                p2++;
                continue;
            }
            if (nums[p2] == flag) {
                p2++;
            }
        }
        return p1;
    }
}

// // 答案做法
// class Solution {
//     public int removeDuplicates(int[] nums) {
//         if(nums == null || nums.length == 0) return 0;
//         int pos = 0,cur = 0,replacePos = 0;
//         while(cur < nums.length){
//             while(cur < nums.length && nums[cur] == nums[pos]) cur++;
//             if(cur - pos >= 2){
//                 nums[replacePos++] = nums[pos];   
//             }
//             nums[replacePos++] = nums[pos];
//             pos = cur;
//         }
//         return replacePos;
//     }
// }



// // 另一个好做法
// class Solution {
//     public int removeDuplicates(int[] nums) {
//         if(nums.length<=1){
//             return nums.length;
//         }
//         // 新数组的最后一个索引位置
//         int current = 1;
//         // 从第三位开始遍历，因为无论如何前两位一定会在新数组中
//         for(int i = 2;i<nums.length;i++){
//             if(nums[i]!=nums[current-1]){
//                 current++;
//                 nums[current] = nums[i];
//             }
//         }
//         return current+1;
//     }
// }
// @lc code=end
