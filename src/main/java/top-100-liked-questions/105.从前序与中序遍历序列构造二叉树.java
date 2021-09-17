/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    //找到父节点是关键 可以用hashmap来找数组中元素的位置o(1)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderIndexs = new HashMap<>();
        for(int i = 0 ;i<inorder.length;i++){
            inorderIndexs.put(inorder[i],i);
        }
        return findFather(preorder,inorder,0,preorder.length-1,0,inorder.length-1,inorderIndexs);
    }
    public TreeNode findFather(int[] preorder, int[] inorder,int preorderStart, int preorderEnd, int inorderStart, int inOrderEnd,Map<Integer,Integer> inorderIndexs){

        TreeNode fatherNode = new TreeNode(preorder[preorderStart]);
        int fatherPreOrderIndex = preorderStart;
        int fatherInOrderIndex = inorderIndexs.get(fatherNode.val);
        if(fatherNode.val == inorder[inorderStart]){//没有左孩子
            fatherNode.left = null;
        }else{//有左孩子
            int newPreOrderStart = preorderStart + 1;
            int newPreOrderEnd = preorderStart + fatherInOrderIndex - inorderStart;;
            int newInOrderStart = inorderStart;
            int newInOrderEnd = fatherInOrderIndex -1 ;
            fatherNode.left = findFather(preorder,inorder,newPreOrderStart,newPreOrderEnd,newInOrderStart,newInOrderEnd,inorderIndexs);
        }
        if(inorder[inOrderEnd] == fatherNode.val){//没有右孩子
            fatherNode.right = null;
        }else{//有右孩子
            int newPreOrderStart = preorderEnd - (inOrderEnd - fatherInOrderIndex) + 1;
            int newPreOrderEnd = preorderEnd;
            int newInOrderStart = fatherInOrderIndex + 1;
            int newInOrderEnd = inOrderEnd;
            fatherNode.right = findFather(preorder,inorder,newPreOrderStart,newPreOrderEnd,newInOrderStart,newInOrderEnd,inorderIndexs);
        }
        return fatherNode;
    }
}
// @lc code=end

