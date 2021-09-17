/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    /**
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        Map<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            hmap.put(nums[i], i);
        }
        int ans = 1;
        for(int i = 0; i < n; i++){
            if(hmap.containsKey(nums[i] - 1)){
                continue;
            }else{
                int t = nums[i];
                int cur_len = 1;
                while(hmap.containsKey(t + 1)){
                    cur_len++;
                    t++;
                }
                ans = Math.max(ans, cur_len);
            }
        }
        return ans;
    }
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
// @lc code=end

