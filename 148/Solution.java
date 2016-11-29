public class Solution {
    public ListNode sortList(ListNode head) {
        // System.out.println("---> sortList: " + head.val);
        if (head == null || head.next == null)
            return head;
        ListNode curr = head, slow = head, fast = head;
        while(fast != null && fast.next != null){
            curr = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode  l2 = curr.next;
        curr.next = null;
        ListNode l1 = sortList(head);
        l2 = sortList(l2);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null)
            curr.next = l1;
        if (l2 != null)
            curr.next = l2;
        return dummy.next;

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode  head = new ListNode(new int[] {1,3,3,1,3,1,3,3,2,3,2,2,1,1,1,3,2,2,1,1,2,2,2,3,3,1,1,2,2,2,1,2,1,1,2,3,3,2,2,3,2,3,2,2,2,1,1,3,2,3,3,1,1,1,2,2,1,2,2,2,2,3,1,3,1,1,1,2,1,2,2,2,1,3,2,2,2,3,3,2,3,3,1,1,2,2,1,2,1,3,2,1,3,3,1,2,1,1,1,1,1,2,1,2,2,2,2,3,3,3,1,1,3,2,1,1,2,1,3,3,2,2,1,3,1,3,1,3,2,2,3,2,3,2,2,1,2,3,1,3,1,2,3,3,2,3,3,3,1,1,2,3,1,2,3,2,1,1,2,3,1,1,3,1,2,2,3,2,1,3,1,2,1,3,2,1,1,2,2,2,3,2,2,2,1,2,3,2,3,3,3,2,3,1,3,3,1,3,3,3,3,1,2,2,2,1,3,3,3,2,3,1,1,2,3,3,3,1,3,3,1,2,3,1,3,1,3,2,1,1,3,3,3,2,2,3,3});
        head.print();
        ListNode newHead = solution.sortList(head);
        newHead.print();
    }
}