public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res += 1 & n;
            n = n >>> 1;
            System.out.println("res : " + res + " n: " + n);
        }
        return res;
    }

    // public static void main(String[] args){
    //     Solution solution = new Solution();
    //     solution.hammingWeight(  2147483648 );
    // }
}