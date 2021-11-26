/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int ind = 0;
        while(ind < s.length()){
            int t = (int) ch[ind];
            if(t >= 48 && t <= 57){
                int rind = numJudge(s, ind);
                int l = Integer.parseInt(s.substring(ind, rind));
                int end = backetJudge(s, rind + 1);
                String subs = decodeString(s.substring(rind + 1, end - 1));
                while(l > 0){
                    sb.append(subs);
                    l--;
                }
                ind = end;
            }else if(t >= 97 && t <= 122){
                sb.append(ch[ind]);
                ind ++;
            }
        }
        return sb.toString();
    }

    public int backetJudge(String s, int ind){
        int backet = 1;
        while(backet != 0){
            if(s.charAt(ind) == '['){
                backet++;
            }else if(s.charAt(ind) == ']'){
                backet--;
            }
            ind++;
        }
        return ind;
    }

    public int numJudge(String s, int ind){
        while((int)s.charAt(ind) >= 48 && (int)s.charAt(ind) <= 57){
            ind++;
        }
        return ind;
    }
}
// @lc code=end

