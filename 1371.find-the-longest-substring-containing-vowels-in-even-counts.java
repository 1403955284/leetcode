import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

/*
 * @lc app=leetcode id=1371 lang=java
 *
 * [1371] Find the Longest Substring Containing Vowels in Even Counts
 */

// @lc code=start
class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        HashMap<Integer, Integer> stateMap = new HashMap<Integer, Integer>();
        hashMap.put('a', 1);
        hashMap.put('e', 2);
        hashMap.put('i', 4);
        hashMap.put('o', 8);
        hashMap.put('u', 16);
        int res = 0;
        int max = 0;
        stateMap.putIfAbsent(0, -1);
        for (int i = 0; i < s.length(); i++) {
            String curStr = s.substring(0, i+1);
            if (hashMap.containsKey(s.charAt(i))) {
                res ^= hashMap.get(s.charAt(i));
            }
            if (stateMap.containsKey(res))
                max = Math.max(max, i - stateMap.get(res));
            stateMap.putIfAbsent(res, i);
            System.out.println(curStr+" "+res);
        }
        return max;
    }
}
// @lc code=end
