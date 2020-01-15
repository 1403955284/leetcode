import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=403 lang=java
 *
 * [403] Frog Jump
 */

// @lc code=start
class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;

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

