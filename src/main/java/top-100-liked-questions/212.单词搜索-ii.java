/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {
    int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<String>();
        Map<Character, List<Integer>> mapping = new HashMap<Character, List<Integer>>();
        int m = board.length, n = board[0].length;
        int k = Math.max(m, n);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mapping.containsKey(board[i][j])){
                    mapping.get(board[i][j]).add(i * k + j);
                }else{
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(i * k + j);
                    mapping.put(board[i][j], l);
                }
            }
        }
        lable1 : for(String word : words){
            if(mapping.containsKey(word.charAt(0))){
                for(int ind : mapping.get(word.charAt(0))){
                    int row = ind / k, col = ind % k;
                    boolean[][] visited = new boolean[m][n];
                    if(backtrack(board, word, row, col, 0, visited)){
                        ans.add(word);
                        continue lable1;
                    }
                }
            }
        }
        return ans;
    }

    public boolean backtrack(char[][] board, String word, int i, int j, int ind, boolean[][] visited){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        if(board[i][j] == word.charAt(ind) && !visited[i][j]){
            if(ind == word.length() - 1){
                return true;
            }
            visited[i][j] = true;
            for(int[] dir : dirs){
                if(backtrack(board, word, i + dir[0], j + dir[1], ind + 1, visited)){
                    return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }
}
// @lc code=end

