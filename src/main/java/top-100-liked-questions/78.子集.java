/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        addSubsets(nums, 0, ans, temp);
        return ans;
    }

    public void addSubsets(int[] nums, int ind, List<List<Integer>> ans,List<Integer> temp){
        if(ind == nums.length){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(nums[ind]);
        addSubsets(nums, ind + 1, ans, temp);
        temp.remove(temp.size() - 1);
        addSubsets(nums, ind + 1, ans, temp);
    }
}
// @lc code=end

