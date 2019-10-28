import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=336 lang=java
 *
 * [336] Palindrome Pairs
 */

// @lc code=start
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        if (words == null || words.length < 2) {
            return ans;
        }
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);
                // 如果左边子串是回文,查看map中是否有右边子串的翻转，如果有，将该串加到word[i]的左边就可以和word[i]组成一个回文字符串
                if (isPalindrome(left)) {
                    String reverseRight = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(reverseRight) && map.get(reverseRight) != i) {
                        List<Integer> tmp = new LinkedList<>();
                        tmp.add(map.get(reverseRight));
                        tmp.add(i);
                        ans.add(tmp);
                    }
                }

                // 如果右边子串是回文,查看map中是否有左边子串的翻转，如果有，将该串加到word[i]的右边就可以和word[i]组成一个回文字符串
                if (isPalindrome(right)) {
                    String reverseLeft = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(reverseLeft) && map.get(reverseLeft) != i && right.length() != 0) {
                        List<Integer> tmp = new LinkedList<>();
                        tmp.add(i);
                        tmp.add(map.get(reverseLeft));
                        ans.add(tmp);
                    }
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
