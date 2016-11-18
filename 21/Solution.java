/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode list1 = l1;
        ListNode list2 = l2;
        ListNode curr = dummy;

        while(list1 != null || list2 != null){
            if(list1 == null){
                curr.next = list2;
                break;
            }
            if(list2 == null){
                curr.next = list1;
                break;
            }
            if (list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}