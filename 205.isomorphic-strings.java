import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        for(int i = 0;i<s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(!map.containsKey(a)&&!map.containsValue(b)){
                map.put(a, b);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(char c:s.toCharArray()){
            stringBuilder.append(map.get(c));
        }
        return stringBuilder.toString().equals(t);
    }
}
// @lc code=end

