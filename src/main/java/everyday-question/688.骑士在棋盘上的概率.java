/*
 * @lc app=leetcode.cn id=688 lang=java
 *
 * [688] 骑士在棋盘上的概率
 */

// @lc code=start
class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] dirs = { { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 } };
        double[][][] dp = new double[k + 1][n][n];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) {
                        dp[step][i][j] = 1;
                    } else {
                        for (int[] dir : dirs) {
                            int ni = i + dir[0], nj = j + dir[1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                dp[step][i][j] += dp[step - 1][ni][nj] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }
}
// @lc code=end
