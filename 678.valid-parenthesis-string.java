
/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {

        // // ================================== 5% ===========================
        // if (s == null || s.length() == 0) {
        //     return true;
        // }
        // return helper(0, s, 0);
        // // =================================================================



        // ======================== post最多的答案 ================================

        /**
         * 从左向右遍历
         * 假如当前遇到的是 ( ，则左括号比右括号多的个数为0;
         * 假如遇到的是 ) ,则左括号比右括号多个个数为-1;
         * 当遇到 * 时 路径开始有分化，如果把*认为是( ,则要在当前基础上+1，认为是 ) 则要-1，认为是空 则不动，所以遇到*时，
         * 可能的count变为集合(count-1,count,count+1);
         * 以 用例 "(**())" 为例解释:
         * ① '(' count:1
         * ② '*' count:0,1,2
         * ③ '*' count:若从上步0过来 -> -1,0,1;
         *              若从上步1过来 -> 0,1,2;
         *              若从上步2过来 -> 1,2,3;
         *              所以可能集合: -1,0,1,2,3   其中-1可以直接略去 -> 0,1,2,3
         * ④ '(' count:1,2,3,4
         * ⑤ ')' count:0,1,2,3
         * ⑥ ')' count:-1,0,1,2 -> 0,1,2
         * 
         * 可以看到有一条路径最终可以使count为0，则返回true；
         * 在实际写的时候，只需要记录这个count范围的左右边界即可，应为内部的数肯定是连续的，随时略去使count小于0的路径
         * 若当右边界high小于0，直接返回false
         */


        // 记录当前左括号个数可能比右括号个数多的个数的情况的集合 的左边界和右边界
        int low = 0;
        int high = 0;
        for(Character cur:s.toCharArray()){
            if(cur=='('){
                low++;
                high++;
            }else if(cur==')'){
                if(low>0){
                    low--;
                }
                high--;
            }else{
                if(low>0){
                    low--;
                }
                high++;
            }

            if(high<0){
                return false;
            }
        }
        return low == 0;


    }

    // count记录当前左括号比右括号多的个数
    public boolean helper(int count, String s, int index) {
        if (count < 0) {
            return false;
        }
        if (count == 0 && index == s.length()) {
            return true;
        }
        if (count != 0 && index == s.length()) {
            return false;
        }

        Character cur = s.charAt(index);
        if (cur == '(') {
            return helper(count + 1, s, index + 1);
        } else if (cur == ')') {
            if (count == 0) {
                return false;
            }
            return helper(count - 1, s, index + 1);
        } else {
            return helper(count, s, index + 1) || helper(count + 1, s, index + 1) || helper(count - 1, s, index + 1);
        }
    }

}
// @lc code=end
