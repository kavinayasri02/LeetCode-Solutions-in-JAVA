class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node=head, ptr=head;
        int k=0;
        while(ptr!=null){
            k++;
            ptr=ptr.next;
        }
        n=k-n+1;
        if(n==1)return head.next;
        for(int i=1; i<n-1; i++){
            node=node.next;
        }
        node.next=node.next.next;
        return head;
    }
}