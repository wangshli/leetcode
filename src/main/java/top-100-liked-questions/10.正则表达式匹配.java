/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 0; i < s.length() + 1; i++){
            for(int j = 1; j < p.length() + 1; j++){
                if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i][j-2];
                    if(i > 0){
                        if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'){
                            dp[i][j] = dp[i-1][j] || dp[i][j-2];
                        }
                    }
                }else if(i > 0){
                    if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
// @lc code=end

