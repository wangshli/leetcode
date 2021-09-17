/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int t1 = nums[0], t2 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            int t = Math.max(t2, t1 + nums[i]);
            t1 = t2;
            t2 = t;
        }
        return t2;
    }
}
// @lc code=end

