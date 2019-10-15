import java.util.Arrays;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    /**
     * 从最外围开始每次寻找’O‘的点，将其标记为’#‘，然后寻找与之相邻的所有’O‘点标记为‘#’
     * 最后剩下来的’O‘替换为’X‘
     * 再将所有’#‘换回’O‘
     */
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0){
            return;
        }
        for(int i = 0;i<board[0].length;i++){
            helper(board, 0, i);
            helper(board, board.length-1, i);
        }
        for(int i = 0;i<board.length;i++){
            helper(board, i, 0);
            helper(board, i, board[0].length-1);
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j] ='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }

    public void helper(char[][] board,int i,int j){
        if(board[i][j]!='O'){
            return;
        }
        board[i][j] = '#';
        LinkedList<Integer[]> queue = new LinkedList<>();
        Integer[] init = new Integer[]{i,j};
        queue.addLast(init);
        while(!queue.isEmpty()){
            Integer[] cur = queue.pollFirst();
            int col = cur[0];
            int raw = cur[1];
            if(col>0&&board[col-1][raw]=='O'){
                board[col-1][raw] = '#';
                queue.addLast(new Integer[]{col-1,raw});
            }
            if(col<board.length-1&&board[col+1][raw]=='O'){
                board[col+1][raw] = '#';
                queue.addLast(new Integer[]{col+1,raw});
            }
            if(raw<board[0].length-1&&board[col][raw+1]=='O'){
                board[col][raw+1] = '#';
                queue.addLast(new Integer[]{col,raw+1});
            }
            if(raw>0&&board[col][raw-1]=='O'){
                board[col][raw-1] = '#';
                queue.addLast(new Integer[]{col,raw-1});
            }
        }
    }
    

}
// @lc code=end

