
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString(){
        String s = Integer.toString(val);
        if (next != null)
            s = s + " -> " + next.toString();
        return s;
    }

    ListNode(String s) {
        String[] ss = s.split("->");
        int n = ss.length;
        int[] ns = new int[n];
        for (int i = 0; i < n; i++){
            ns[i] = new Integer(ss[i].trim());
        }
        this.val = ns[0];
        ListNode l = this;
        for (int i = 1; i < n; i++){
            ListNode temp = new ListNode(ns[i]);
            l.next = temp;
            l = temp;
        }
    }
}