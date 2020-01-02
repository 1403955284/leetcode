import java.util.Arrays;

/*
 * @lc app=leetcode id=801 lang=java
 *
 * [801] Minimum Swaps To Make Sequences Increasing
 */

// @lc code=start
class Solution {
    public int minSwap(int[] A, int[] B) {
        int n = A.length ;
        
        if (n == 0) return 0 ;
        
        int[] keep = new int[n] ;
        int[] swap = new int[n] ;
        
        Arrays.fill(keep, Integer.MAX_VALUE) ;
        Arrays.fill(swap, Integer.MAX_VALUE) ;
        
        swap[0] = 1 ;
        keep[0] = 0 ;
        
        for(int i = 1 ; i < n ; i++) {
            if( A[i] > A[i-1] && B[i] > B[i-1]) {
                keep[i] = keep[i-1] ;
                swap[i] = swap[i-1] + 1 ;
            }
            
            if(A[i] > B[i-1] && B[i] > A[i-1]) {
                swap[i] = Math.min(swap[i], keep[i-1] + 1) ;
                keep[i] = Math.min(keep[i], swap[i-1]) ;
            }
        }
        
        return Math.min(keep[n-1], swap[n-1]) ;
    }
}
// @lc code=end

