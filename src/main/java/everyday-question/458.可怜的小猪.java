/*
 * @lc app=leetcode.cn id=458 lang=java
 *
 * [458] 可怜的小猪
 */

// @lc code=start
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int states = minutesToTest / minutesToDie + 1;
        int pigs = (int) Math.ceil(Math.log(buckets) / Math.log(states));
        return pigs;
    }
}
// @lc code=end

