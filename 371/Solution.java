public class Solution {
    public int getSum(int a, int b) {
        int base = a;
        int carryOn = b;
        int tmp;
        while (carryOn != 0){
            tmp = base ^ carryOn;
            carryOn = (base & carryOn) << 1;
            base = tmp;
        }
        return base;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.getSum(123, 24));
    }

}