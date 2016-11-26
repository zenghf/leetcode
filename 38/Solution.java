import java.util.ArrayList;

public class Solution {
    private static ArrayList<String> dic;
    static{
        dic = new ArrayList<>();
        dic.add("1");
    }

    public String countAndSay(int n) {
        int len = dic.size();
        if (n <= len)
            return dic.get(n - 1);
        else{
            String curr = dic.get(len - 1);
            for(int i = len; i < n; i++){
                curr = next(curr);
                dic.add(curr);
            }
            return curr;
        }
    }

    public String next(String curr){
        StringBuilder sb = new StringBuilder();
        char prev = ' ';
        int n = 0;
        for (char ch : curr.toCharArray()){
            if (ch != prev){
                if (n > 0){
                    sb.append(Integer.toString(n));
                    sb.append(prev);
                }
                n = 1;
                prev = ch;
            }
            else
                n++;
        }
        sb.append(Integer.toString(n));
        sb.append(prev);
        return sb.toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String curr = "1";
        for (int i = 0; i < 10; i++){
            System.out.println(curr);
            curr = solution.next(curr);
        }
    }
}