/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        int p = -1, q = -1;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)){
                if(p == -1){
                    p = i;
                }else if(q == -1){
                    q = i;
                    break;
                }
            }
        }
        if(p != -1 && q != -1 && s.charAt(p) == goal.charAt(q) && s.charAt(q) == goal.charAt(p)){
            return true;
        }
        //s == goal
        if(p == -1 && q == -1){
            
        }
        return false;
    }
}
// @lc code=end

