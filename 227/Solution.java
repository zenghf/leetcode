import java.util.*;

public class Solution {
    public int calculate(String s) {
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> syms = new LinkedList<>();
        int n = 0;
        for (int i = 0; i <= s.length(); i++){
            char ch = i < s.length() ? s.charAt(i) : '+';
            System.out.println("" + i + ":" + ch + "  " + nums + syms);
            if (ch == ' ')
                continue;
            if ( ch > '9' || ch < '0'){
                if (syms.size() > 0){
                    char sym = syms.peek();
                    if (sym == '/' || sym == '*'){
                        syms.pop();
                        int num = nums.pop();
                        n = sym == '/' ? num / n : num * n;
                    }
                    else if (syms.size() == 2){
                        int num1 = nums.pollLast();
                        int num2 = nums.pollLast();
                        if (syms.pollLast() == '-')
                            num2 = - num2;
                        nums.addLast(num1 + num2);
                    }
                }
                nums.push(n);
                syms.push(ch);
                n = 0;
            }
            else{
                n = 10 * n + (ch - '0');
            }
        }
        if (syms.size() > 0)
            syms.pop();
        if (syms.size() == 0)
            return nums.pop();
        int num2 = nums.pop();
        if (syms.pop() == '-')
            num2 = - num2;
        int num1 = nums.pop();
        return num1 + num2;
    }

    public static void main(String[] args){
        String s = "1*2-3/4+5*6-7*8+9/10";
        Solution solution = new Solution();
        System.out.println(solution.calculate(s));
    }
}