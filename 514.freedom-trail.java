import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=514 lang=java
 *
 * [514] Freedom Trail
 */

// @lc code=start
class Solution {
    public int findRotateSteps(String ring, String key) {
        List<Integer>[] indexs = new List[26];
        for (int i = 0; i < 26; i++) {
            indexs[i] = new ArrayList<>();
        }
        for (int i = 0; i < ring.length(); i++) {
            indexs[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[key.length()][ring.length()];
        return dfs(dp, indexs, 0, 0, ring.length(), key.toCharArray());
    }

    // // 超时
    // public int helper(String rings,int ringsIndex,String key,int keyIndex,int
    // count){
    // if(keyIndex==key.length()){
    // return count;
    // }
    // if(count>key.length()*rings.length()+key.length()){
    // return Integer.MAX_VALUE;
    // }
    // if(rings.charAt(ringsIndex)==key.charAt(keyIndex)){
    // int leftIndex = ringsIndex-1 == -1? rings.length()-1:ringsIndex -1;
    // int rightIndex = ringsIndex+1 == rings.length()?0:ringsIndex+1;
    // return Math.min(helper(rings, leftIndex, key, keyIndex+1, count+1),
    // helper(rings, rightIndex, key, keyIndex+1, count+1));
    // }
    // else{
    // int leftIndex = ringsIndex-1 == -1? rings.length()-1:ringsIndex -1;
    // int rightIndex = ringsIndex+1 == rings.length()?0:ringsIndex+1;
    // return Math.min(helper(rings, leftIndex, key, keyIndex, count+1),
    // helper(rings, rightIndex, key, keyIndex, count+1));
    // }
    // }

    // // 超时
    // public int helper(String ring, int ringIndex, String key, int keyIndex, int count) {
    //     if (keyIndex == key.length()) {
    //         return count;
    //     }
    //     if (count > key.length() * ring.length() + key.length()) {
    //         return Integer.MAX_VALUE;
    //     }
    //     if (ring.charAt(ringIndex) == key.charAt(keyIndex)) {
    //         return helper(ring, ringIndex, key, keyIndex + 1, count);
    //     }
    //     int leftTmp = 0;
    //     int rightTmp = 0;
    //     int leftIndex = ringIndex;
    //     int rightIndex = ringIndex;
    //     while (ring.charAt(leftIndex) != key.charAt(keyIndex)) {
    //         leftIndex = leftIndex - 1 == -1 ? ring.length() - 1 : leftIndex - 1;
    //         leftTmp++;
    //     }
    //     while (ring.charAt(rightIndex) != key.charAt(keyIndex)) {
    //         rightIndex = rightIndex + 1 == ring.length() ? 0 : rightIndex + 1;
    //         rightTmp++;
    //     }
    //     return Math.min(helper(ring, leftIndex, key, keyIndex + 1, count + leftTmp),
    //             helper(ring, rightIndex, key, keyIndex + 1, count + rightTmp));

    // }


    public int dfs(int[][] dp, List<Integer>[] indexs, int pos, int pre, int n, char[] chs) {
        if (pos == chs.length) return 0;
        if (dp[pos][pre] > 0) return dp[pos][pre];
        int min = Integer.MAX_VALUE;
        for (int index : indexs[chs[pos] - 'a']) {
            int d = Math.abs(index - pre);
            int move = Math.min(d, n - d) + 1;
            min = Math.min(min, move + dfs(dp, indexs, pos + 1, index, n, chs));
        }
        dp[pos][pre] = min;
        return min;
    }
}
// @lc code=end
