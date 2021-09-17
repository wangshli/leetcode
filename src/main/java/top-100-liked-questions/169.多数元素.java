/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int n = 1;
        int majornum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(n == 0){
                majornum = nums[i];
            }
            if(nums[i] == majornum){
                n++;
            }else{
                n--;
            }
        }
        n = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == majornum){
                n++;
            }
        }
        if(n > nums.length/2){
            return majornum;
        }
        return 0;
    }
}
// @lc code=end

