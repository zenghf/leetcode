import java.util.BitSet;
public class Solution {
    public boolean isHappy(int n) {
        BitSet hash = new BitSet(162);
        while(true){

            if (n == 1)
                return true;
            if (n < 162){
                if (hash.get(n))
                    return false;
                hash.set(n);
            }
            n = nextSquareSum(n);
        }

    }

    private int nextSquareSum(int n){
        int sum = 0;
        while (n != 0){
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}