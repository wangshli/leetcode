/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
/* class Solution {
    public void moveZeroes(int[] nums) {
        int firstZero = 0, nFirstZero = 0;
        while(firstZero < nums.length && nFirstZero < nums.length){
            while(firstZero < nums.length && nums[firstZero] != 0 ){
                firstZero++;
            }
            while(nFirstZero < nums.length && nums[nFirstZero] == 0 ){
                nFirstZero++;
            }
            if(nFirstZero < nums.length && firstZero < nFirstZero){
                int t = nums[firstZero];
                nums[firstZero] = nums[nFirstZero];
                nums[nFirstZero] = t;
                firstZero++;
            }else{
                nFirstZero++;
            }
        }
    }
} */

/* class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
} */
class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for(int x : nums)
            if(x != 0) nums[k++] = x;
        while(k < nums.length)  nums[k++] = 0;      
    }
}


// @lc code=end

