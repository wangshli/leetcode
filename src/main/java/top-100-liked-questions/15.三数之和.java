/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    //排序+枚举
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < len; i++){
            if(i > 0 && nums[i - 1] == nums[i])
                continue;
            int p = i + 1, q = len - 1;
            while(p < q){
                if(nums[i] + nums[p] + nums[q] == 0){
                    r.add(Arrays.asList(nums[i], nums[p], nums[q]));
                    while(p < q && nums[p] == nums[p + 1]) p++;
                    while(p < q && nums[q] == nums[q - 1]) q--;
                    p++; q--;
                }else if(nums[i] + nums[p] + nums[q] > 0)
                    q--;
                else
                    p++;
            }
        }
        return r;
    }
}
// @lc code=end

