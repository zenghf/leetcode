public class Solution {
    public boolean isValid(String s) {
        String map = "()[]{}";
        StringBuilder stack = new StringBuilder();
        for(char c : s.toCharArray()){
            int ind = map.indexOf(c);
            if (ind == -1)
                return false;
            if (ind % 2 == 0)
                stack.append(c);
            else{
                if (stack.length() == 0)
                    return false;
                if (stack.charAt(stack.length() - 1) == map.charAt(ind - 1))
                    stack.deleteCharAt(stack.length() - 1);
                else
                    return false;
            }
        }
        return stack.length() == 0;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String str = "[(])";
        System.out.println(str + " : " + solution.isValid(str));
    }
}