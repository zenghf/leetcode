/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode frontier = dummy;
        ListNode first = head;
        ListNode second = null;
        ListNode newStart = null;
        while(first != null && first.next != null){
            second = first.next;
            newStart = second.next;

            frontier.next = second;
            second.next = first;

            frontier = first;
            first = newStart;
        }
        frontier.next = first;
        return dummy.next;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode node = new ListNode(new int[]{0, 1, 2, 3, 4, 5, 6});
        node.print();
        ListNode swapNode = solution.swapPairs(node);
        swapNode.print();
    }



}