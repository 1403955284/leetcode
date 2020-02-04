/*
 * @lc app=leetcode id=820 lang=java
 *
 * [820] Short Encoding of Words
 */

// @lc code=start
class Solution {
    public int minimumLengthEncoding(String[] words) {
        int n = words.length;
        String[] revWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            revWords[i] = sb.reverse().toString();
        }
        int res = 0;
        Arrays.sort(revWords);
        for (int i = 0; i < revWords.length - 1; i++) {
            if (!revWords[i + 1].startsWith(revWords[i])) { // 后面的字符不以当前打头
                res += (revWords[i].length() + 1);
            }
        }
        res += (revWords[n - 1].length() + 1);
        return res;
    }
}
// @lc code=end
