import java.util.*;

public class Solution2 {
    public int nthUglyNumber(int n) {
        if (n < 7)
            return n;
        class Node{
            int val;
            Node next;
            Node(int x){
                this.val = x;
            }
        }
        Node head = new Node(1);
        Node head2 = head, head3 = head, head5 = head;
        Node tail = new Node(2);
        head.next = tail;
        int k = 2;
        while (k < n){
            int t = tail.val;
            while (head2.val * 2 <= t)
                head2 = head2.next;
            while (head3.val * 3 <= t)
                head3 = head3.next;
            while (head5.val * 5 <= t)
                head5 = head5.next;
            int min = Math.min(Math.min(head2.val * 2, head3.val * 3), head5.val * 5);
            Node node = new Node(min);
            tail.next = node;
            tail = node;
            k++;
        }
        System.out.println(Integer.MAX_VALUE);
        // System.out.println("++++++++++++");
        Node node = head;
        while(node != null){
            System.out.println(" " + node.val);
            node = node.next;
        }
        // System.out.println("------------");
        return tail.val;
    }

    public static void main(String[] args){
        int n = 1600;//1600;
        Solution2 solution = new Solution2();
        int res = solution.nthUglyNumber(n);
        System.out.println(res);
    }
}