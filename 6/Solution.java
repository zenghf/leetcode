public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int n = s.length();
        StringBuilder zigzag = new StringBuilder();
        // if (numRows == 2){
        //     for (int i = 0; i < n; i += 2)
        //         zigzag.append(s.charAt(i));
        //     for (int i = 1; i < n; i += 2)
        //         zigzag.append(s.charAt(i));
        //     return new String(zigzag);
        // }

        for (int row = 0; row < numRows; row++){
            int inc1 = 2 * numRows - 2 - 2 * row;
            int inc2 = 2 * row;
            int[] inc = {inc1, inc2};
            if (inc1 == 0)
                inc = new int[] {inc2};
            else if (inc2 == 0)
                inc = new int[] {inc1};
            int curr = row;
            int ind = 0;
            int indLength = inc.length;
            while (curr < n){
                zigzag.append(s.charAt(curr));
                curr += inc[ind];
                ind = (ind + 1) % indLength;
            }
        }
        return new String(zigzag);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = solution.convert("ABCD", 2);
        System.out.println(s.length());
        System.out.println(s);
    }
}