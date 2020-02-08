import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> strMap = new HashMap<>();
        for (String str : strs) {
            char chars[] = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!strMap.containsKey(key)) {
                strMap.put(key, new ArrayList<>());
            }
            strMap.get(key).add(str);
        }
        return new ArrayList(strMap.values());
    }
}
// @lc code=end
