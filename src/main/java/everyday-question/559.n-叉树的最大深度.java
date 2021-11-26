/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N 叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        if(root.children == null){
            return 1;
        }
        int deep = 0;
        for(int i = 0; i < root.children.size(); i++){
            deep = Math.max(deep, maxDepth(root.children.get(i)));
        }
        return deep + 1;
    }
}
// @lc code=end

