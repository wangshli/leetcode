/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
/*
class Solution {
    public int trap(int[] height) {
        if(height.length <= 2)  return 0;
        int rain = 0;
        int h = height.length;
        int[] left = new int[h];
        int[] right = new int[h];
        left[0] = height[0];
        right[h - 1] = height[h - 1];
        for(int i  = 1; i < h; i++){
            left[i] = Math.max(height[i], left[i - 1]);
        }
        for(int i = h - 2; i >= 0; i--){
            right[i] = Math.max(height[i], right[i + 1]);
        }
        for(int i = 0; i < h; i++){
            rain += Math.min(left[i], right[i]) - height[i];
        }
        return rain;
    }
}
*/
class Solution{
public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= left_max) {
                left_max = height[left];
            } else {
                ans += (left_max - height[left]);
            }
            ++left;
        } else {
            if (height[right] >= right_max) {
                right_max = height[right];
            } else {
                ans += (right_max - height[right]);
            }
            --right;
        }
    }
    return ans;
}
}
// @lc code=end

