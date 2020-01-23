import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=433 lang=java
 *
 * [433] Minimum Genetic Mutation
 */

// @lc code=start
class Solution {
    private int ans = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        // =============================== 回溯  time:5.25% ======================

        Map<Character,List<String>> map = new HashMap<>();
        map.put('A', Arrays.asList("C","T","G"));
        map.put('C', Arrays.asList("A","T","G"));
        map.put('T', Arrays.asList("A","C","G"));
        map.put('G', Arrays.asList("A","T","C"));

        List<String> newBank = new ArrayList<>();
        Map<String,Boolean> used = new HashMap<>();
        for(String cur:bank){
            newBank.add(cur);
            used.put(cur, false);
        }

        back(start, end, newBank, used,map,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    public void back(String cur,String target,List<String> bank,Map<String,Boolean> used,Map<Character,List<String>> map,int times){
        if(cur.equals(target)){
            ans = Math.min(ans,times);
        }
        for(int i = 0;i<cur.length();i++){
            Character curChange = cur.charAt(i);
            for(String tmp:map.get(curChange)){
                String str = new StringBuilder(cur).replace(i, i+1, tmp).toString();
                if(bank.contains(str)&&!used.get(str)){
                    used.put(str, true);
                    back(str, target, bank, used, map, times+1);
                    used.put(str, false);
                }
                
            }
        }
        
    }
}
// @lc code=end

