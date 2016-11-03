public class Solution {
    public int reverse(int x) {
        if (x == -2147483648)
            return 0;
        String minus = "";
        if (x < 0){
            x = -x;
            minus = "-";
        }
        Integer X = new Integer(x);
        String s = X.toString();
        StringBuilder sb = new StringBuilder(s.length() + 1);
        sb.append(minus);

        // check over flow
        // MAX_INT = 2147483647
        // MIN_INT = -2147483648
        String max = "2147483647";
        if (minus.length() == 1)
            max = "2147483648";
        // System.out.println(s);
        if (s.length() == 10){
            for(int i = 9; i >= 0; i--){
                // System.out.println(s.charAt(i) + " " + max.charAt(9 - i));
                int d = s.charAt(i) - max.charAt(9 - i);
                if (d > 0)
                    return 0;
                if (d < 0)
                    break;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        String invs = new String(sb);
        System.out.println(invs);
        int invx = Integer.parseInt(invs);
        return invx;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int a = solution.reverse(-2147483412);
        System.out.println(a);
    }
}