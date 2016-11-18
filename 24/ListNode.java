
public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }

     ListNode(int[] nums){
        val = nums[0];
        ListNode node = this;
        ListNode newNode = null;
        for(int i = 1; i < nums.length; i++){
            newNode = new ListNode(nums[i]);
            node.next = newNode;
            node = newNode;
        }
     }

    public void print(){
        System.out.print("[");
        ListNode node = this;
        while(node != null){
            System.out.print("" + node.val + " ");
            node = node.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args){
        ListNode node = new ListNode(new int[]{0, 1, 2, 3});
        node.print();
    }


}
