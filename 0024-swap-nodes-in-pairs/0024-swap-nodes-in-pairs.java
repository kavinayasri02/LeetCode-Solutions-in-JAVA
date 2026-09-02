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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null)  return head;
        ListNode prev = head;
        ListNode SP = head;
        ListNode curr = head.next;
        int count = 0;
        while(curr!=null){
            prev.next = curr.next;
            if(SP != head)
                SP.next = curr;
            SP = prev;
            curr.next = prev;
            prev = prev.next;
            if(count==0){
                head=curr;
                count=1;
            }
            if(prev==null)//null->next = NULL POINTER EXCEPTION for that reason
                break;
            curr = prev.next;
        }
        return head;
    }
}