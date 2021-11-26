/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/* 超时 
class Solution {
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        int par = 0, chl = 0;
        par += root.val;
        if(root.left != null){
            chl += rob(root.left);
            par += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            chl += rob(root.right);
            par += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(par, chl);
    }
} */
class Solution {
    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int selected = node.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}

// @lc code=end

