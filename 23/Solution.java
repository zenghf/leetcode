/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int N;
    public ListNode mergeKLists(ListNode[] lists) {
        N = 0;
        int n = lists.length;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        ListNode[] heads = new ListNode[n];
        for (int i = 0; i < n; i++)
            heads[i] = lists[i];
        int[] pq = new int[n + 1];
        for(int i = 0; i < n; i++)
            insert(pq, heads, i);
        while(N != 0){
            int k = pop(pq, heads);
            head.next = heads[k];
            head = heads[k];
            heads[k] = heads[k].next;
            insert(pq, heads, k);
        }
        return dummy.next;
    }

    private void insert(int[] pq, ListNode[] heads, int i){
        System.out.println("insert : " + i);
        if (heads[i] == null)
            return;
        pq[N] = i;
        int curr = N;
        int parent = (curr - 1) / 2;
        while(curr > 0 && heads[pq[parent]].val > heads[pq[curr]].val){
            int temp = pq[parent];
            pq[parent] = pq[curr];
            pq[curr] = temp;
            curr = parent;
            parent = (curr - 1) / 2;
        }
        // heads[i] = heads[i].next;
        N++;
        printPQ(pq);
    }

    private int pop(int[] pq, ListNode[] heads){
        int res = pq[0];
        pq[0] = pq[N - 1];
        int parent = 0;
        while( 2 * parent + 1 < N - 1){
            int minChild = 2 * parent + 1;
            if (minChild + 1 < N - 1 && heads[pq[minChild + 1]].val < heads[pq[minChild]].val)
                minChild++;
            if (heads[pq[minChild]].val < heads[pq[parent]].val){
                int temp = pq[parent];
                pq[parent] = pq[minChild];
                pq[minChild] = temp;
            }
            else
                break;
            parent = minChild;
        }
        N--;
        System.out.println("pop " + res);
        printPQ(pq);
        return res;
    }

    private void printPQ(int[] pq){
        System.out.print("pq: ");
        for (int i = 0; i < N; i++)
            System.out.print(" " + pq[i]);
        System.out.println();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        // ListNode node1 = new ListNode(9);
        // ListNode node2 = new ListNode(8);
        // ListNode[] lists = new ListNode[]{node1, node2};
        // [[-10,-9,-9,-3,-1,-1,0],[-5],[4],[-8],[],[-9,-6,-5,-4,-2,2,3],[-3,-3,-2,-1,0]]
        ListNode[] lists = new ListNode[]{new ListNode(new int[]{-10,-9,-9,-3,-1,-1,0}),
                                          new ListNode(-5),
                                          new ListNode(4),
                                          new ListNode(-8),
                                          null,
                                          new ListNode(new int[]{-9,-6,-5,-4,-2,2,3}),
                                          new ListNode(new int[]{-3,-3,-2,-1,0})};
        solution.mergeKLists(lists).print();
    }
}