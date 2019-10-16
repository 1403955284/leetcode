import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class Solution {
    class Trie {
        String Word;

        Trie[] childer = new Trie[26];

        public Trie add(char c) {
            if (childer[c - 'a'] != null) {
                return childer[c - 'a'];
            } else {
                childer[c - 'a'] = new Trie();
                return childer[c - 'a'];
            }
        }
    }

    private List<String> ans = new LinkedList<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie cur = root;
            for (char c : word.toCharArray()) {
                cur = cur.add(c);
            }
            cur.Word = word;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] isVisit = new boolean[board.length][board[0].length];
                helper(root, board, i, j, isVisit);
            }
        }
        return ans;
    }

    public void helper(Trie root, char[][] board, int i, int j, boolean[][] isVisit) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || isVisit[i][j]) {
            return;
        }
        root = root.childer[board[i][j] - 'a'];
        isVisit[i][j] = true;
        if (root != null) {
            if (root.Word != null) {
                ans.add(root.Word);
                root.Word = null;
            }
            helper(root, board, i + 1, j, isVisit);
            helper(root, board, i - 1, j, isVisit);
            helper(root, board, i, j + 1, isVisit);
            helper(root, board, i, j - 1, isVisit);

        }
        isVisit[i][j] = false;
    }
}
// @lc code=end
