/*
 * @lc app=leetcode.cn id=1791 lang=java
 *
 * [1791] 找出星型图的中心节点
 */

// @lc code=start
class Solution {
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
// @lc code=end

