public class Solution {
    public boolean isMatch(String s, String p) {
        // System.out.println("" + level + " " + s + " : " + p);
        // if the pattern (p) is empty, it only matches an empty string (s)
        if (p.isEmpty())
            return s.isEmpty();
        // delete leading star
        if (p.charAt(0) == '*')
            return isMatch(s, p.substring(1));

        // find the first none wildcard string;
        char prevCh = '*';
        int start = 0, end = 0;
        int ind = 0;
        boolean findNoneWildcard = false;
        for (int i = 0; i < p.length(); i++){
            char ch = p.charAt(i);
            if ((ch != '*' && ch != '.') && (prevCh =='*' || prevCh == '.')){
                start = i;
            }
            if ((ch == '*' || ch == '.') && (prevCh !='*' && prevCh != '.')){
                end = i;
                if (ch == '*')
                    end--;
                if (end > start){
                    findNoneWildcard = true;
                    break;
                }
            }
            prevCh = ch;
        }
        if (!findNoneWildcard && prevCh != '*' && prevCh != '.')
            end = p.length();
        if (end > start){
            // System.out.println("branch none wildcard" + " " + start + " " + end);
            int len = end - start;
            String left = p.substring(0, start);
            String middle = p.substring(start, end);
            String right = p.substring(end, p.length());
            int fromIndex = 0;
            while(true){
                ind = s.indexOf(middle, fromIndex);
                if (ind == -1)
                    return false;
                else if (isMatchWildcard(s.substring(ind + len), right) && isMatch(s.substring(0, ind), left))
                    return true;
                fromIndex = ind + 1;
            }
        }
        return false;
    }

    public boolean isMatchWildcard(String s, String p){
        if(p.isEmpty())
            return s.isEmpty;
        if (p.charAt[0] == '*')
            return isMatchWildcard(s, p.substring(1));
        if (p.charAt[0] == '.' && (p.length() == 1 || p.charAt(1) != '*'))
            return !s.isEmpty() && isMatchWildcard(s.substring(1), p.substring(1));
        assert p.charAt(1) == '*';
        String p2 = p.substring(2);
        if (p.charAt(0) == '.'){
            for (int i = 0; i <= s.length(); i++){
                if (isMatch(s.substring(i), p2))
                    return true;
            }
            return false;
        }
        // c*
        else{
            char ch = p.charAt(0);
            int curr = 0;
            while (curr < s.length() && s.charAt(curr) == ch){
                if (isMatch(s.substring(curr), p2))
                    return true;
                curr++;
            }
            return isMatch(s.substring(curr), p2);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aaa", "a.a"));
    }
}