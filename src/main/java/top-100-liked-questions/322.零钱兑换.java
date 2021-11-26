/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        Arrays.sort(coins);
        for(int i = 1; i <= amount; i++){
            int coinnum = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin <= i) {
                    if (dp[i - coin] != -1) {
                        coinnum = Math.min(coinnum, dp[i - coin] + 1);
                    }
                } else {
                    break;
                }
            }
            dp[i] = coinnum == Integer.MAX_VALUE ? -1 : coinnum;
        }
        return dp[amount];
    }
}
// @lc code=end

