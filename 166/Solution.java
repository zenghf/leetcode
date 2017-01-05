import java.util.HashMap;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        boolean isNegative = (numerator < 0) ^ (denominator < 0);
        long numer = (long) numerator;
        long denom = (long) denominator;
        numer = numer > 0 ? numer : -numer;
        denom = denom > 0 ? denom : -denom;
        StringBuilder sb = new StringBuilder();
        if (isNegative)
            sb.append('-');
        long n = numer / denom;
        sb.append(n);
        long r = numer - n * denom;
        if (r == 0)
            return sb.toString();

        sb.append(".");
        HashMap<Long, Integer> pos = new HashMap<>();
        int k = sb.length();
        while (r != 0){
            if (pos.containsKey(r)){
                sb.insert(pos.get(r), "(");
                sb.append(")");
                break;
            }
            pos.put(r, k);
            k++;
            r *= 10;
            long temp = r / denom;
            sb.append(temp);
            r = r - temp * denom;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.fractionToDecimal(1, 214748364));
    }
}