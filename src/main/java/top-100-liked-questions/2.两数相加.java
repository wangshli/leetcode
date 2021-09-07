/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val == 0 && l1.next == null)
            return l2;
        else if(l2.val == 0 && l2.next == null)
            return l1;
        ListNode r = new ListNode((l1.val + l2.val)%10);
        int carry = (l1.val + l2.val)/10;
        
        l1 = (l1.next == null)? null:l1.next;
        l2 = (l2.next == null)? null:l2.next;
        ListNode p = r;
        int result;
        while(l1 != null && l2 != null){
            result = l1.val + l2.val + carry;
            carry = result/10;
            ListNode q = new ListNode(result%10, null);
            p.next = q;
            p = q;
            l1 = l1.next; l2 = l2.next;
        }
        while((l1 == null && l2 != null)||(l1 != null && l2 == null)){
            result = (l1==null)?(l2.val+carry):(l1.val+carry);
            carry = result/10;
            ListNode q = new ListNode(result%10, null);
            p.next = q;
            p = q;
            l1 = (l1==null)?null:l1.next;
            l2 = (l2==null)?null:l2.next;
        }
        if(carry != 0){
            ListNode q = new ListNode(carry, null);
            p.next = q;
            p = q;
        }
        return r;
    }
}
// @lc code=end

