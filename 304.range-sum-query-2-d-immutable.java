/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
    private int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(matrix==null){ return 0;}
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = 0;
        if(row1<0||row2<0||col1<0||col2<0||row1>=n||row2>=n||col1>=m||col2>=m){
            return 0;
        }
        for(int i =row1;i<=row2;i++){
            for(int j =col1;j<=col2;j++){
                ans+=matrix[i][j];
            }
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

