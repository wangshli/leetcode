/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int minsq = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++){
                minsq = Math.min(minsq, dp[i - j * j]);
            }
            dp[i] = minsq + 1;
        }
        return dp[n];
    }
}
// @lc code=end

