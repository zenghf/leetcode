public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int n1 = num1.length();
        int n2 = num2.length();
        int[] digits = new int[n1 + n2];
        for (int i = 0; i < n1; i++){
            for (int j = 0; j < n2; j++){
                int v = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                digits[n1 + n2 - 2 - i - j] += v;
            }
        }
        for (int i = 0; i < n1 + n2; i++){
            int d = digits[i];
            if (d >= 10){
                digits[i + 1] += d / 10;
                digits[i] = d % 10;
            }
        }
        StringBuilder sb = new StringBuilder(n1 + n2);
        int k = n1 + n2 - 1;
        if (digits[k] == 0)
            k--;
        for (; k >= 0; k--)
            sb.append(digits[k]);
        return sb.toString();
    }
}