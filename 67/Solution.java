public class Solution {
    public String addBinary(String a, String b) {
        int n = Math.max(a.length(), b.length());
        int la = a.length();
        int lb = b.length();
        char[] digits = new char[n];
        digits[0] = '0';
        int carrayon = 0;
        for (int i = 0; i < n; i++){
            int A = 0, B = 0;
            if (i < la)
                A = a.charAt(la - i - 1) - '0';
            if (i < lb)
                B = b.charAt(lb - i - 1) - '0';
            System.out.println("A" + A + " B" + B + " carrayon" + carrayon);
            int v = A + B + carrayon;
            carrayon = v / 2;
            digits[n - i - 1] = (char)('0' + (v % 2));
        }
        String str = new String(digits);
        System.out.println("*" + str + "*");
        if (carrayon == 1)
            return "1" + str;
        else
            return str;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.addBinary(args[0], args[1]);
    }
}