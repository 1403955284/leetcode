import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=791 lang=java
 *
 * [791] Custom Sort String
 */

// @lc code=start
class Solution {
    public String customSortString(String S, String T) {
        Map<Character,Integer> record = new HashMap<>();
        List<Character> save = new ArrayList<>();
        int i = 0;
        for(Character cur:S.toCharArray()){
            if(!record.containsKey(cur)){
                record.put(cur, i++);
            }
        }
        for(Character cur:T.toCharArray()){
            save.add(cur);
        }
        Collections.sort(save, new Comparator<Character>() {

            @Override
            public int compare(Character o1, Character o2) {
                if(record.containsKey(o1)&&record.containsKey(o2)){
                    return record.get(o1)-record.get(o2);
                }else if(record.containsKey(o1)&&!record.containsKey(o2)){
                    return -1;
                }else if(!record.containsKey(o1)&&record.containsKey(o2)){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        StringBuilder ans = new StringBuilder();
        for(Character cur:save){
            ans.append(cur);
        }
        return ans.toString();
    }
}
// @lc code=end

