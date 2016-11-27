public class MinStack {

    /** initialize your data structure here. */

    class Node{
        private int val;
        private int min;
        private Node next;
        private Node(int x){
            val = x;
            min = x;
        }
    }

    Node head;

    public MinStack() {
    }

    public void push(int x) {
        Node node = new Node(x);
        node.next = head;
        if (head != null && x > head.min)
            node.min = head.min;
        head = node;
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */