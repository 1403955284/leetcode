/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] str1= new int[26];
        int[] str2 = new int[26];
        for(char cur :s.toCharArray()){
            str1[cur-'a']++;
        } 
        for(char cur:t.toCharArray()){
            str2[cur-'a']++;
        }
        for(int i = 0;i<26;i++){
            if(str1[i]!=str2[i]){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

