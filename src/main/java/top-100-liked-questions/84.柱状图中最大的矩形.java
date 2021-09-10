/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
/**
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        int ans = 0;
        for(int i = 0; i < heights.length; i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int t = st.pop();
                ans = Math.max(heights[t] * (i - t), ans);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int t = st.pop();
            ans = Math.max(heights[t] * (heights.length - t), ans);
        }
        return ans;
    }
}
*/
/**
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                right[st.peek()] = i;
                st.pop();
            }
            left[i] = (st.isEmpty() ? -1 : st.peek());
            st.push(i);
        }
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }
        ;
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end

