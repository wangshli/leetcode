/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int p = 0, q = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] == 2 && i <= q){
                int temp = nums[i];
                nums[i] = nums[q];
                nums[q] = temp;
                q--;
            }
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
    }
}
// @lc code=end

