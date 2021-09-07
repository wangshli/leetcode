/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    /** 
    public int jump(int[] nums) {
        int l = nums.length;
        int[] step = new int[l];
        Arrays.fill(step, l);
        step[l - 1] = 0;
        for(int i = l - 2; i >= 0; i--){
            if(nums[i] >= l - 1 - i){
                step[i] = 1;
            }else{
                for(int j = 0; j < nums[i]; j++){
                    step[i] = Math.min(step[i], step[i + j + 1] + 1);
                }
            }
        }
        return step[0];
    }
    */

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0; 
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]); 
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }



}
// @lc code=end

