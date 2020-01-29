import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=677 lang=java
 *
 * [677] Map Sum Pairs
 */

// @lc code=start
class MapSum {

    private Map<String, Integer> map;

    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int res = 0;
        for (String cur : map.keySet()) {
            if (cur.startsWith(prefix) || cur.equals(prefix)) {
                res += map.get(cur);
            }
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such: MapSum obj = new
 * MapSum(); obj.insert(key,val); int param_2 = obj.sum(prefix);
 */
// @lc code=end
