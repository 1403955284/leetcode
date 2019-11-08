import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=554 lang=java
 *
 * [554] Brick Wall
 */

// @lc code=start
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int ans = wall.size();
        int length = 0;
        List<Integer> init = wall.get(0);
        Set<Integer> setLength = new HashSet<>();
        for (int cur : init) {
            length += cur;
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < wall.size(); i++) {
            List<Integer> tmp = new ArrayList<>();
            List<Integer> curWall = wall.get(i);
            int curLength = 0;
            for (int cur : curWall) {
                curLength += cur;
                tmp.add(curLength);
                if (curLength != length) {
                    setLength.add(curLength);
                }
            }
            list.add(tmp);
        }

        // // 遍历的可能的入口length太多，直接超时了，
        // for(int i = 1;i<length;i++){
        // int curAns = 0;
        // for(List<Integer> cur:list){
        // if(!cur.contains(i)){
        // curAns++;
        // }
        // }
        // // System.out.println(curAns);
        // ans = Math.min(ans,curAns);
        // }

        // 只遍历那些可能成为入口的length，减少了遍历次数
        for (int i : setLength) {
            int curAns = 0;
            for (List<Integer> cur : list) {
                if (!cur.contains(i)) {
                    curAns++;
                }
            }
            ans = Math.min(ans, curAns);
        }

        return ans;
    }
}
// @lc code=end
