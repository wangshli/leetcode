/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) {
            return intervals;
        }
        intervals = quicksort(intervals, 0, intervals.length - 1);
        List<int[]> ans = new ArrayList<int[]>();
        ans.add(intervals[0]);
        int k = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= ans.get(k)[1]){
                ans.get(k)[1] = Math.max(intervals[i][1], ans.get(k)[1]);
            }else{
                ans.add(intervals[i]);
                k++;
            }
        }
        int[][] ret = new int[ans.size()][2];
        for(int j = 0; j < ans.size(); j++){
            ret[j] = ans.get(j);
        }
        return ret;
    }
    public int[][] quicksort(int[][] intervals, int low, int high){
        int pivot = intervals[low][0];
        int i = low, j = high;
        while(i < j){
            while(intervals[j][0] > pivot && i < j){
                j--;
            }
            while(intervals[i][0] < pivot && i < j){
                i++;
            }
            if(intervals[i][0] == intervals[j][0] && i < j){
                i++;
            }else if(i != j){
                int[] temp = intervals[i];
                intervals[i] = intervals[j];
                intervals[j] = temp;
            }
        }
        if(i - 1 > low){
            intervals = quicksort(intervals, low, i - 1);
        }
        if(j + 1 < high){
            intervals = quicksort(intervals, j + 1, high);
        }
        return intervals;
    }
}
// @lc code=end

