/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode evenHead = head;
        ListNode oddHead = head.next;
        ListNode even = evenHead, odd = oddHead;
        ListNode curr = oddHead.next;
        boolean turnForEven = true;
        while(curr != null){
            if (turnForEven){
                even.next = curr;
                even = curr;
            }
            else{
                odd.next = curr;
                odd = curr;
            }
            turnForEven = !turnForEven;
            curr = curr.next;
        }
        odd.next = null;
        even.next = oddHead;
        return evenHead;
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        solution.oddEvenList(head).print();
    }
}