/*
 * @lc app=leetcode id=600 lang=java
 *
 * [600] Non-negative Integers without Consecutive Ones
 */

// @lc code=start
class Solution {
    public int findIntegers(int num) {

        // // 暴力解法，超时
        // int ans = 0;
        // for(int i = num;i>=0;i--){
        //     int count = 0;
        //     int tmp = i;
        //     while(tmp!=0&&count!=2){
        //         if((tmp&1)==1){
        //             count++;
        //         }else{
        //             count = 0;
        //         }
        //         tmp>>=1;
        //     }
        //     if(count!=2){
        //         ans++;
        //     }
        // }
        // return ans;


        if (num == 0) return 1;
    if (num == 1) return 2;
    int nbits = 0;
    while((num>>nbits)>0) {
        ++nbits;
    }
    
    if (num>>(nbits - 2) == 3) {
        return fib(nbits);
    } else {
        int mask = (1 << (nbits - 1)) - 1;
        return fib(nbits - 1) + findIntegers(num & mask);
    }
}

    int fib(int n) {
        if (n <= 0) return 1;
        if (n == 1) return 2;
        int a = 1;
        int b = 2;
        int c = 3;
        int i = n - 2;
        while(i>0) {
            a = b;
            b = c;
            c = a + b;
            i--;
        }
        return c;

        // 直接递归时间复杂度很高
        // return fib(n-1)+fib(n-2);
    }
}
// @lc code=end

