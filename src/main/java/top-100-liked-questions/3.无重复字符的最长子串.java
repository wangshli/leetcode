/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
/**
 *字串中字母记录在hashmap中，判断是否有重复
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        int len = s.length();
        int p = 0, q = 1, t = 1;
        int r = t;
        Map<Character, Integer> hashtable = new HashMap<Character, Integer>();
        hashtable.put(s.charAt(q-1), q-1);
        while(q < len){
            q++;
            if(hashtable.containsKey(s.charAt(q-1))){
                int x = hashtable.get(s.charAt(q-1));
                for(; p <= x; p++){
                    hashtable.remove(s.charAt(p));
                }
                t = q - p;
            }else{
                t++;
                r = (r>t)?r:t;
            }
            hashtable.put(s.charAt(q-1), q-1);
        }
        return r;
    }
}
*/
//滑动窗口
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}


// @lc code=end

