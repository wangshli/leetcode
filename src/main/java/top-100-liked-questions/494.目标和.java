/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
/* class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        hmap.put(nums[0], 1);
        if(nums[0] != 0){
            hmap.put(-nums[0], 1);
        }else{
            hmap.put(0, 2);
        }
        for(int i = 1; i < nums.length; i++){
            Map<Integer, Integer> nhmap = new HashMap<Integer, Integer>();
            for(Map.Entry<Integer, Integer> entry : hmap.entrySet()){
                nhmap.put(entry.getKey() + nums[i], nhmap.getOrDefault(entry.getKey() + nums[i], 0) + entry.getValue());
                nhmap.put(entry.getKey() - nums[i], nhmap.getOrDefault(entry.getKey() - nums[i], 0) + entry.getValue());
            }
            hmap = nhmap;
        }
        return hmap.getOrDefault(target, 0);
    }
}  */
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }
}

// @lc code=end

