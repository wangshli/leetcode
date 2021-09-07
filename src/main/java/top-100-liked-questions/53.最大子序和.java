/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1 )   return nums[0];
        int sum = nums[0], max = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
}
// @lc code=end

