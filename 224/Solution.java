public class Solution {
    public int calculate(String s) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> symbles = new LinkedList<>();
        s = s.replaceAll(" ", "");
        int n = s.length();
        int i = 0;
        boolean isPrevLeftPar = false;
        while(i < n){
            int j = i;
            while (j < n && Character.isDigit(s.charAt(j)))
                j++;
            if (j == i){
                j++;
                if (s.charAt(i) == '(')
                    isPrevLeftPar = true;
                else if (s.charAt(i) == ')')
                    calculate(nums, symbles);
                else if (s.charAt(i) == '+')
                    symbles.push('+');
                else if (s.charAt(i) == '-')
                    symbles.push('-');
            }
            else{
                int num = Integer.parseInt(s.substring(i, j));
                nums.push(num);
                if (!isPrevLeftPar)
                    calculate(nums, symbles);
                isPrevLeftPar = false;
            }
            i = j;
        }
        return nums.pop();
    }

    public void calculate(Deque<Integer> nums, Deque<Character> symbles){
        if (symbles.isEmpty())
            return;
        int num2 = nums.pop();
        int num1 = nums.pop();
        char symb = symbles.pop();
        int num = num1 + num2;
        if (symb == '-')
            num = num1 - num2;
        nums.push(num);
    }
}