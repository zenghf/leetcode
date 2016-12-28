public class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i < n - 1; i++){
            for (int j = i + 1; j < n; j++){
                if (num.charAt(i) == '0' && j > i + 1)
                    break;
                if (num.charAt(j) == '0')
                    continue;
                if (n - j < Math.max(i, j - i))
                    break;
                int n1 = 0, n2 = i, n3 = j, n4 = j;
                boolean isAdditive = true;
                while (isAdditive){
                    if (n - n3 < Math.max(n2 - n1, n3 - n2))
                        break;
                    int[] digits = add(num, n1, n2, n3);
                    int k = digits[0] == 0 ? 1 : 0;
                    for (; k < digits.length; k++, n4++){
                        if (n4 >= n || num.charAt(n4) - '0' != digits[k]){
                            isAdditive = false;
                            break;
                        }
                    }
                    if (n4 == n)
                        return true;
                    n1 = n2;
                    n2 = n3;
                    n3 = n4;
                }
            }
        }
        return false;
    }

    private int[] add(String num, int n1, int n2, int n3){
        int[] digits = new int[Math.max(n2 - n1, n3 - n2) + 1];
        int i = n2 - 1;
        int j = n3 - 1;
        int k = Math.max(n2 - n1, n3 - n2) ;
        int carryon = 0;
        for (; i >= n1 || j >= n2; i--, j--, k--){
            int num1 = 0, num2 = 0;
            if (i >= n1)
                num1 = num.charAt(i) - '0';
            if (j >= n2)
                num2 = num.charAt(j) - '0';
            int sum = num1 + num2 + carryon;
            carryon = sum / 10;
            digits[k] = sum - carryon * 10;
        }
        if (carryon == 1)
            digits[0] = 1;
        return digits;
    }
}