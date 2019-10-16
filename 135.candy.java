/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        if(ratings==null||ratings.length==0){
            return 0;
        }
        int[] candyNum = new int[ratings.length];
        int minIndex = 0;
        int minRatingValue = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0;i<ratings.length;i++){
            if(ratings[i]<minRatingValue){
                minRatingValue = ratings[i];
                minIndex = i;
            }
        }
        candyNum[minIndex] = 1;
        for(int i = minIndex+1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                candyNum[i] = candyNum[i-1]+1;
            }else if(ratings[i]<ratings[i-1]&&candyNum[i-1]==1){
                candyNum[i] = 1;
                int checkIndex = i;
                while(checkIndex>0&&ratings[checkIndex]<ratings[checkIndex-1]&&candyNum[checkIndex-1]<=candyNum[checkIndex]){
                    candyNum[checkIndex-1] = candyNum[checkIndex]+1;
                    checkIndex--;
                }
            }else{
                candyNum[i] = 1;
            }
        }
        for(int i = minIndex-1;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candyNum[i] = candyNum[i+1]+1;
            }else if(ratings[i]<ratings[i+1]&&candyNum[i+1]==1){
                candyNum[i] = 1;
                int checkIndex = i;
                while(checkIndex<ratings.length-1&&ratings[checkIndex]<ratings[checkIndex+1]&&candyNum[checkIndex+1]<=candyNum[checkIndex]){
                    candyNum[checkIndex+1] = candyNum[checkIndex]+1;
                    checkIndex++;
                }
            }else{
                candyNum[i] = 1;
            }
        }
        for(int cur:candyNum){
            ans+=cur;
            System.out.println(cur);
        }
        return ans;
    }
}
// @lc code=end

