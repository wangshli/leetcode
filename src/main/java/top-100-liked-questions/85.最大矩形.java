/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 */

// @lc code=start
/**

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        if(n == 0){
            return 0;
        }
        //dp记录与当前位置构成最大矩形的下标为300*row+col+1;(row, cols <= 200)
        int[][] dp = new int[m][n];
        dp[0][0] = (matrix[0][0] == '1') ? 1 : 0;
        int rt = dp[0][0];
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == '1'){
                if(dp[i - 1][0] == 0){
                    dp[i][0] = 300 * i + 1;
                    rt = Math.max(rt, 1);
                }else{
                    dp[i][0] = dp[i - 1][0];
                    rt = Math.max(rt, i - (dp[i-1][0]-1)/300 + 1);
                }
            }
        }
        for(int j = 1; j < n; j++){
            if(matrix[0][j] == '1'){
                if(dp[0][j - 1] == 0){
                    dp[0][j] = j + 1;
                    rt = Math.max(rt, 1);
                }else{
                    dp[0][j] = dp[0][j - 1];
                    rt = Math.max(rt, j - dp[0][j - 1] + 2);
                }
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1'){
                    int cor1 = acor(matrix, i, j, dp[i - 1][j]);
                    int cor2 = acor(matrix, i, j, dp[i][j - 1]);
                    int a1 = area(i, j, cor1);
                    int a2 = area(i, j, cor2);
                    if(a1 < a2){
                        dp[i][j] = cor2;
                        rt = Math.max(rt, a2);
                    }else{
                        dp[i][j] = cor1;
                        rt = Math.max(rt, a1);
                    }
                }
            }
        }
        return rt;
    }

    public int acor(char[][] matrix, int i, int j, int coordinate){
        if(coordinate == 0){
            return i * 300 + j + 1;
        }
        int li = (coordinate - 1) / 300, lj = (coordinate - 1) % 300;
        if(li == i || lj == j){
            return coordinate;
        }
        int ri = i, rj = j;
        while(ri >= li && matrix[ri][j] == '1'){
            ri--;
        }
        ri++;
        while(rj >= lj && matrix[i][rj] == '1'){
            rj--;
        }
        rj++;
        return ri * 300 + rj + 1;
    }

    public int area(int i, int j, int cor){
        int li = (cor - 1) / 300, lj = (cor - 1) % 300;
        return (i - li + 1) * (j - lj + 1);
    }
}*/
/**
记录i，j位置左连续'1'
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }
}
*/
//单调栈优化
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int col = matrix.length;
        int row = matrix[0].length;
        int[] heights = new int[row];
        int ans = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }

    /**
     * 84. 柱状图中最大的矩形
     */
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

