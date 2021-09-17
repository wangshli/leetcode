/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node preans = new Node(0);
        Node t = head, newLink = preans;
        Map<Node, Node> hmap = new HashMap<Node, Node>();
        while(t != null){
            if(hmap.containsKey(t)){
                newLink.next = hmap.get(t);
            }else{
                Node newNode = new Node(t.val);
                newLink.next = newNode;
                hmap.put(t, newNode);
            }
            newLink = newLink.next;
            if(t.random == null){
                newLink.random = null;
            }else if(hmap.containsKey(t.random)){
                newLink.random = hmap.get(t.random);
            }else{
                Node newNode = new Node(t.random.val);
                newLink.random = newNode;
                hmap.put(t.random, newNode);
            }
            t = t.next;
        }
        return preans.next;
    }
}
// @lc code=end

