/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
 /** 
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode Phead = new ListNode();
        Phead.next = head;
        ListNode p = head, pre = Phead;
        int step = 0;
        while(p.next != null){
            if(p.val > p.next.val){
                ListNode t = p.next.next;
                pre.next = p.next;
                p.next.next = p;
                p.next = t;
                pre = pre.next;
            }else{
                p = p.next;
                pre = pre.next;
            }
            step++;
        }
        for(int i = step - 1; i > 0; i--){
            p = Phead.next;
            pre = Phead;
            int flag = 0;
            int s = i;
            while(s > 0){
                if(p.val > p.next.val){
                    ListNode t = p.next.next;
                    pre.next = p.next;
                    p.next.next = p;
                    p.next = t;
                    pre = pre.next;
                    flag = 1;
                }else{
                    p = p.next;
                    pre = pre.next;
                }
                s--;
            }
            if(flag == 0){
                break;
            }
        }
        return Phead.next;
    }
}
*/

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}

// @lc code=end

