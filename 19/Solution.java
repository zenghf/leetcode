public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int N = 0;
        ListNode front = dummy;
        ListNode behind = dummy;
        for (int i = 0; i <= n + 1; i++)
            front = front.next;

        while(front != null){
            front = front.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;
        return dummy.next;
    }
}