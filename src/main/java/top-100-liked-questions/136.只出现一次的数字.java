/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
/**
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(num_set.contains(nums[i])){
                num_set.remove(nums[i]);
            }else{
                num_set.add(nums[i]);
            }
        }
        return num_set.iterator().next();
    }
}
*/

class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}

// @lc code=end

