/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        if(n <= 2){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            if(i % 2 == 0){
                for(int left = 0; left < i/2; left++){
                    dp[i] += 2 * dp[i - left - 1] * dp[left];
                }
            }else{
                for(int left = 0; left < i/2; left++){
                    dp[i] += 2 * dp[i - left - 1] * dp[left];
                }
                dp[i] += dp[(i - 1)/2] * dp[(i - 1)/2];
            }
        }
        return dp[n];
    }
}
// @lc code=end

