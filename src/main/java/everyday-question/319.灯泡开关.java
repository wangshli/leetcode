/*
 * @lc app=leetcode.cn id=319 lang=java
 *
 * [319] 灯泡开关
 */

// @lc code=start
class Solution {
    public int bulbSwitch(int n) {
        /*if(n == 0){
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for(int i = 2; i <= n; i++){
            for(int j = i; j <= n; j += i){
                dp[j] = dp[j] == 0 ? 1 : 0;
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans += dp[i];
        }
        return ans;*/
        return (int) Math.sqrt(n + 0.5);
    }
}
// @lc code=end

