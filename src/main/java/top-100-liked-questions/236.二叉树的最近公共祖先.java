/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /* public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if (root!=null){
            TreeNode lNode = lowestCommonAncestor(root.left,p,q);
            TreeNode rNode = lowestCommonAncestor(root.right,p,q);
            if (lNode!=null&&rNode!=null)
                return root;
            else if(lNode==null) {//两个都在右子树
                return rNode;
            }
            else { //两个都在左子树里面
                return lNode;
            }
        }
        return null;
    } */

    /* public void postOrder(TreeNode root){
        Map<TreeNode, Integer> hmap = new HashMap<TreeNode, Integer>();
        List<TreeNode> t = new ArrayList<TreeNode>();//stack
        while(root != null || !t.isEmpty()){
            while(root != null){
                t.add(root);
                hmap.put(root, 0);
                root = root.left;
            }
            root = t.removeLast();
            if(hmap.get(root) == 0){
                t.add(root);
                hmap.put(root, 1);
                root = root.right;
            }else{
                root = null;
            }

        }
    } */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        Map<TreeNode, Integer> hmap = new HashMap<TreeNode, Integer>();
        List<TreeNode> t = new ArrayList<TreeNode>();//stack
        List<TreeNode> pAncestor = new ArrayList<>(), qAncestor = new ArrayList<>();
        int pflag = 0, qflag = 0;
        while(root != null || !t.isEmpty()){
            while(root != null){
                t.add(root);
                hmap.put(root, 0);
                if(root == p){
                    Collections.addAll(pAncestor, new TreeNode[t.size()]);
                    Collections.copy(pAncestor, t);
                    pflag = 1;
                }
                if(root == q){
                    Collections.addAll(qAncestor, new TreeNode[t.size()]);
                    Collections.copy(qAncestor, t);
                    qflag = 1;
                }
                if(pflag == 1 && qflag == 1){
                    return getCommonAncestor(pAncestor, qAncestor);
                }
                root = root.left;
            }
            root = t.remove(t.size() - 1);
            if(hmap.get(root) == 0){
                t.add(root);
                hmap.put(root, 1);
                root = root.right;
            }else{
                root = null;
            }
        }
        return getCommonAncestor(pAncestor, qAncestor);
    }

    public TreeNode getCommonAncestor(List<TreeNode> pAncestor, List<TreeNode> qAncestor){
        int l = Math.min(pAncestor.size(), qAncestor.size());
        TreeNode ans = null;
        for(int i = 0; i < l; i++){
            if(pAncestor.get(i) == qAncestor.get(i)){
                ans = pAncestor.get(i);
            }else{
                break;
            }
        }
        return ans;
    }
}
// @lc code=end

