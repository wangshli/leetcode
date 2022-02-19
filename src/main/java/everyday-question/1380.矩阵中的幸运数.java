import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

/*
 * @lc app=leetcode.cn id=1380 lang=java
 *
 * [1380] 矩阵中的幸运数
 */

// @lc code=start
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ret = new LinkedList<>();
        Map<Integer, Integer> hmap = new HashMap<>(); //记录每行的最小值和其列数
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int rm = matrix[i][0], col = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < rm) {
                    rm = matrix[i][j];
                    col = j;
                }
            }
            hmap.put(rm, col);
        }
        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            boolean flag = true;
            for (int i = 0; i < m; i++) {
                if (matrix[i][v] > k) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ret.add(k);
            }
        }
        return ret;
    }
}
// @lc code=end

