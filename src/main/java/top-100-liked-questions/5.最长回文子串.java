/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    /**
    动态规划
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        char[] schararray = s.toCharArray();
        int left = 0, right = 0, maxlen = 1;
        for(int l = 2; l < len; l++){
            for(int i = 0; i < len - l + 1; i++){
                int j = i + l - 1;
                if(l == 2){
                    if(schararray[i] == schararray[j]){
                        dp[i][j] = true;
                        if(l > maxlen){
                            left = i; right = j; maxlen = l;
                        }
                    }
                }else{
                    if(schararray[i] == schararray[j] && dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        if(l > maxlen){
                            left = i; right = j; maxlen = l;
                        }
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
    */
    //中心扩展
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
// @lc code=end

