/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int t = 1, cur = 0;
        for(int i = 1; i <= n; i++){
            if(i == t){
                dp[i] = 1;
                cur = t;
                t = t * 2;
            }else{
                dp[i] = dp[i - cur] + 1;
            }
        }
        return dp;
    }
}
// @lc code=end

