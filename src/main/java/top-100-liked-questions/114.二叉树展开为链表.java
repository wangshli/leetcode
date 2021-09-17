/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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

class Solution {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode t = root;
        if(root.left != null){
            t = root.left;
            while(t.right != null){
                t = t.right;
            }
            TreeNode r = root.right;
            root.right = root.left;
            t.right = r;
        }
        t = root;
        while(t != null){
            t.left = null;
            t = t.right;
        }
        return;
    }
}
// @lc code=end

