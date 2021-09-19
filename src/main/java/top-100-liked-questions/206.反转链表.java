/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dhead = new ListNode(0, null);
        while(head != null){
            ListNode t = head.next;
            head.next = dhead.next;
            dhead.next = head;
            head = t;
        }
        return dhead.next;
    }
}
// @lc code=end

