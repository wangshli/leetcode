/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int[] appear = new int[nums.length - 1];
        for(int i : nums){
            if(appear[i - 1] == 0){
                appear[i - 1] = 1;
            }else{
                return i;
            }
        }
        return 0;
    }
}
// @lc code=end

