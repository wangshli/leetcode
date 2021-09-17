/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
 /**
class Solution {
    public boolean isSymmetric(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        Deque<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        TreeNode temp, last = root;
        while(!que.isEmpty()){
            temp = que.poll();
            if(temp.left != null){
                que.add(temp.left);
                ls.add(temp.left.val);
            }else{
                ls.add(null);
            }
            if(temp.right != null){
                que.add(temp.right);
                ls.add(temp.right.val);
            }else{
                ls.add(null);
            }
            if(temp == last){
                if(!layerSymmetric(ls)){
                    return false;
                }
                last = que.getLast();
                ls.clear();
            }
        }
        return true;
    }

    public boolean layerSymmetric(List<Integer> ls){
        int n = ls.size();
        for(int i = 0; i < n/2; i++){
            if(ls.get(i) != ls.get(n - i - 1)){
                return false;
            }
        }
        return true;
    }
}
*/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}

// @lc code=end

