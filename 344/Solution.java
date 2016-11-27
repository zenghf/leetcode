public class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.reverseString("abc"));
    }
}