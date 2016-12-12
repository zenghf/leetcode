import java.util.Arrays;
import java.util.Comparator;


public class Solution {
    public String largestNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            ss[i] = "" + nums[i];
        Arrays.sort(ss, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                int n = Math.max(o1.length(), o2.length());
                int m = Math.min(o1.length(), o2.length());
                int N = m;
                while( N < n)
                    N += m;
                for (int i = 0; i < N; i++){
                    int d = o1.charAt(i % o1.length()) - o2.charAt(i % o2.length());
                    if (d != 0)
                        return -d;
                }
                return 0;
            }
        });
        if (ss.length == 0 || ss[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : ss)
            sb.append(s);
        return sb.toString();
    }

    public static void main(String[] args){
        int[] nums = new int[]{121, 12};
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(nums));
    }
}