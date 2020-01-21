import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=290 lang=java
 *
 * [290] Word Pattern
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(strs.length!=pattern.length()){
            return false;
        }
        int length = strs.length;
        boolean flag = true;
        Map<Character,String> map = new HashMap<>();
        for(int i = 0;i<length&&flag;i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(strs[i]))
                    return false;
            }else{
                if(map.containsValue(strs[i]))
                    return false;
                map.put(c, strs[i]);
            } 
        }
        return flag;
    }
}
// @lc code=end

