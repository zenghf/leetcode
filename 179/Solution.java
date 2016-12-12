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
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
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