import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start

class TrieNode {
    public boolean isWord;
    public TrieNode[] children;

    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}

// ============================= 比使用HashMap要快，30ms，98%
// ===============================
class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char tmp : word.toCharArray()) {
            if (cur.children[tmp - 'a'] == null) {
                cur.children[tmp - 'a'] = new TrieNode();
            }
            cur = cur.children[tmp - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char tmp : word.toCharArray()) {
            if (cur.children[tmp - 'a'] == null) {
                return false;
            }
            cur = cur.children[tmp - 'a'];
        }
        return cur.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char tmp : prefix.toCharArray()) {
            if (cur.children[tmp - 'a'] == null) {
                return false;
            }
            cur = cur.children[tmp - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
// @lc code=end
