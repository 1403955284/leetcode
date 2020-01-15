import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=403 lang=java
 *
 * [403] Frog Jump
 */

// @lc code=start
class Solution {
    public boolean canCross(int[] stones) {
        boolean[][] dp = new boolean[stones.length][stones.length];
        dp[0][0] = true;
        for(int cur:stones){
            
        }
    }


//     // ============================== 超时 ====================================
//     public boolean DFS(List<Integer> indexs,int index,int step,int target){
//         if(index>target){
//             return false;
//         }
//         if(index==target){
//             return true;
//         }
//         if(step==0){
//             return indexs.contains(1)&&DFS(indexs, index+1, 1,target);
//         }else if(step==1){
//             return (indexs.contains(index+1)&&DFS(indexs, index+1, 1,target)) 
//                 || (indexs.contains(index+2)&&DFS(indexs, index+2, 2,target));
//         }else{
//             return (indexs.contains(index+(step-1))&&DFS(indexs, index+(step-1), step-1,target)) 
//                   ||(indexs.contains(index+step)&&DFS(indexs, index+step, step,target))
//                   ||(indexs.contains(index+(step+1))&&DFS(indexs, index+(step+1), step+1,target));
//     }
// }
}
// @lc code=end

