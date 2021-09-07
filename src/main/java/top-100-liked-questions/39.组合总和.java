/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        backtrack(candidates, target, candidates.length - 1, temp, ans);
        return ans;
    }

    public void backtrack(int[] candidates, int remain, int ind, List<Integer> temp, List<List<Integer>> ans){
        if(remain == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = ind; i >= 0; i--){
            if(candidates[i] <= remain){
                temp.add(candidates[i]);
                backtrack(candidates, remain - candidates[i], i, temp, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
// @lc code=end

