/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 */

// @lc code=start
class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
        }
        int ans = 0;
        for(int num : hmap.keySet()){
            //int t = Math.max(hmap.get(num) + hmap.getOrDefault(num - 1, 0), hmap.get(num) + hmap.getOrDefault(num + 1, 0));
            if(hmap.containsKey(num + 1)){
                ans = Math.max(ans , hmap.get(num) + hmap.get(num + 1));
            }
        }
        return ans;
    }
}
// @lc code=end

