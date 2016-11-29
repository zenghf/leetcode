public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail){
        ListNode leftHead = null, leftTail = null, rightHead = null, rightTail = null, curr = null, next = null;
        ListNode midHead = null, midTail = null;
        curr = head.next;
        boolean findsFirstLeft = false;
        boolean findsFirstRight = false;
        boolean findsFirstMid = false;
        while(curr != tail){
            next = curr.next;
            if (curr.val < head.val){
                curr.next = leftHead;
                leftHead = curr;
                if (!findsFirstLeft){
                    leftTail = curr;
                    findsFirstLeft = true;
                }
            }
            else if(curr.val > head.val){
                curr.next = rightHead;
                rightHead = curr;
                if (!findsFirstRight){
                    rightTail = curr;
                    findsFirstRight = true;
                }
            }
            else{
                curr.next = midHead;
                midHead = curr;
                if (!findsFirstMid){
                    midTail = curr;
                    findsFirstMid = true;
                }
            }
            curr = next;
        }

        if (findsFirstMid)
            head.next = midHead;
        else
            midTail = head;
        if (findsFirstRight){
            rightTail.next = tail;
            midTail.next = sortList(rightHead, tail);
        }
        else{
            midTail.next = tail;
        }
        if (findsFirstLeft){
            leftTail.next = head;
            return sortList(leftHead, head);
        }
        else{
            return head;
        }

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode  head = new ListNode(new int[] {1,3,3,1,3,1,3,3,2,3,2,2,1,1,1,3,2,2,1,1,2,2,2,3,3,1,1,2,2,2,1,2,1,1,2,3,3,2,2,3,2,3,2,2,2,1,1,3,2,3,3,1,1,1,2,2,1,2,2,2,2,3,1,3,1,1,1,2,1,2,2,2,1,3,2,2,2,3,3,2,3,3,1,1,2,2,1,2,1,3,2,1,3,3,1,2,1,1,1,1,1,2,1,2,2,2,2,3,3,3,1,1,3,2,1,1,2,1,3,3,2,2,1,3,1,3,1,3,2,2,3,2,3,2,2,1,2,3,1,3,1,2,3,3,2,3,3,3,1,1,2,3,1,2,3,2,1,1,2,3,1,1,3,1,2,2,3,2,1,3,1,2,1,3,2,1,1,2,2,2,3,2,2,2,1,2,3,2,3,3,3,2,3,1,3,3,1,3,3,3,3,1,2,2,2,1,3,3,3,2,3,1,1,2,3,3,3,1,3,3,1,2,3,1,3,1,3,2,1,1,3,3,3,2,2,3,3});
        head.print();
        ListNode newHead = solution.sortList(head);
        newHead.print();
    }
}