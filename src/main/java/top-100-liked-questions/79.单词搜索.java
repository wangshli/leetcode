/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if(m * n < word.length()){
            return false;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isExist(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isExist(char[][] board, String word, int i, int j, int ind){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(ind)){
            return false;
        }
        if(ind == word.length() - 1){
            return true;
        }
        char t = board[i][j];
        board[i][j] = '0';
        boolean ret = isExist(board, word, i + 1, j, ind + 1) ||
            isExist(board, word, i, j + 1, ind + 1) ||
            isExist(board, word, i - 1, j, ind + 1) ||
            isExist(board, word, i, j - 1, ind + 1);
        board[i][j] = t;
        return ret;
    }
}
// @lc code=end

