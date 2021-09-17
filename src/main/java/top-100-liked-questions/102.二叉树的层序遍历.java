/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> t = new ArrayList<Integer>();
        Deque<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        TreeNode temp, last = root;
        while(!que.isEmpty()){
            temp = que.poll();
            t.add(temp.val);
            if(temp.left != null){
                que.add(temp.left);
            }
            if(temp.right != null){
                que.add(temp.right);
            }
            if(temp == last){
                ans.add(new ArrayList<Integer>(t));
                t.clear();
                if(!que.isEmpty()){
                    last = que.getLast();
                }
            }
        }
        return ans;
    }
}
// @lc code=end

