/*
 * @lc app=leetcode.cn id=969 lang=java
 *
 * [969] 煎饼排序
 */

// @lc code=start
class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ret = new LinkedList<>();
        for (int n = arr.length; n > 1; n--) {
            int ind = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > arr[ind]) {
                    ind = i;
                }
            }
            if (ind == n - 1) {
                continue;
            }
            reverse(arr, ind);
            ret.add(ind + 1);
            reverse(arr, n - 1);
            ret.add(n);
        }
        return ret;
    }

    public void reverse(int[] arr, int end) {
        for (int i = 0, j = end; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
// @lc code=end

