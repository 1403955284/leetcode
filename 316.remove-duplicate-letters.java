import java.util.Stack;
/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        // 1、遍历字符串里的字符，如果读到的字符的 ASCII 值是升序，依次存到一个栈中；
        // 2、如果读到的字符在栈中已经存在，这个字符我们不需要；
        // 3、如果读到的 ASCII 值比栈顶元素严格小，看看栈顶元素在后面是否还会出现，如果还会出现，则舍弃栈顶元素，而选择后出现的那个字符，这样得到的字典序更小。
        
        // 记录当前操作的字符在栈中是否已经出现过
        boolean[] set = new boolean[26];
        // 记录每个字符最后出现的索引序号
        int[] record = new int[26];
        for(int i = 0;i<s.length();i++){
            record[s.charAt(i)-'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char cur = s.charAt(i);
            if(set[cur-'a']){
                continue;
            }
            while(!stack.isEmpty()&&stack.peek()>cur&&record[stack.peek()-'a']>=i){
                char top = stack.pop();
                set[top-'a'] = false;
            }
            stack.push(cur);
            set[cur-'a'] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
// @lc code=end

