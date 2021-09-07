/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        for(int i : nums){
            temp.add(i);
        }
        backtrack(0, temp, ans);
        return ans;

    }

    public void backtrack(int ind, List<Integer> temp, List<List<Integer>> ans){
        if(ind == temp.size()){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = ind; i < temp.size(); i++){
            Collections.swap(temp, ind, i);
            backtrack(ind + 1, temp, ans);
            Collections.swap(temp, ind, i);
        }

    }
}
// @lc code=end

