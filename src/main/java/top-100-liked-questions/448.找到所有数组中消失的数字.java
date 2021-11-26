/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
/* class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] appear = new int[n + 1];
        for(int i = 0; i < n; i++){
            appear[nums[i]] = 1;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
            if(appear[i] == 0){
                ret.add(i);
            }
        }
        return ret;
    }
} */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }
}

// @lc code=end

