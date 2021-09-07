/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int length = nums.length;
        int maxPosition = 0;
        for (int i = 0; i < length; i++) {
            if(i <= maxPosition){
                maxPosition = Math.max(maxPosition, i + nums[i]);
                if(maxPosition >= length - 1){
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }
}
// @lc code=end

