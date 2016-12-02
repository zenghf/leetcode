import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int v = 0;
        for (String s : tokens){
            if (s.length() > 1 || Character.isDigit(s.charAt(0)))
                stack.push(Integer.parseInt(s));
            else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (s.charAt(0) == '+')
                    v = num1 + num2;
                else if (s.charAt(0) == '-')
                    v = num1 - num2;
                else if (s.charAt(0) == '*')
                    v = num1 * num2;
                else if (s.charAt(0) == '/')
                    v = num1 / num2;
                stack.push(v);
            }
        }
        return stack.peek();
    }
}