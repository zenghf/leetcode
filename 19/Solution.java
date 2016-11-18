public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int N = 0;
        ListNode node = head;
        while(node != null){
            N++;
            node = node.next;
        }
        if (n == N)
            return head.next;

        node = head;
        for (int i = 0; i < N - n - 1; i++)
            node = node.next;
        node.next = node.next.next;
        return head;
    }
}