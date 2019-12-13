/*
 * @lc app=leetcode id=792 lang=java
 *
 * [792] Number of Matching Subsequences
 */

// @lc code=start
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        for(String cur:words){
            if(cur.length()>S.length()){
                continue;
            }
            boolean flag = true;
            int start = 0;
            int end = S.length()-1;
            for(int i = 0;i<cur.length()&&flag;i++){
                Character tmp = cur.charAt(i);
                int index = Search(S, start, end, tmp);
                // System.out.println("当前验证cur:"+cur+"  当前验证字母:"+tmp+"  当前验证结果:"+index+" 当前start:"+start);
                if(index==-1){
                    flag = false;
                }else{
                    start = index+1;
                }
            }
            if(flag){
                ans++;
            }
        }
        return ans;
    }

    public int Search(String S,int start,int end,Character target){
        for(int i = start;i<=end;i++){
            if(S.charAt(i)==target){
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

