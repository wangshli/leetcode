/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
/**
暴力
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target)
                    return new int[] {i,j};
            }
        }
        return new int[] {};
    }
}
*/

/**
先排序
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        int i = 0, j = nums.length - 1;
        while(temp[i] + temp[j] != target){
            if(temp[i] + temp[j] < target)
                i++;
            else
                j--;
        }
        int ind1 = 0, ind2 = nums.length - 1;
        for(int k = 0; k < nums.length; k++){
            if(nums[k] == temp[i]){
                ind1 = k;
                break;
            }
        }
        for(int k = nums.length - 1; k >= 0; k--){
            if(nums[k] == temp[j]){
                ind2 = k;
                break;
            }
        }
        return new int[] {ind1, ind2};
    } 
}
*/
//hash
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}


// @lc code=end

