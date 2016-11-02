public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int n = s.length();
        char[] zigzag = new char[n];

        int cycle = 2 * numRows - 2;
        int k = 0;
        int curr = 0;
        while(curr < n){
            zigzag[k++] = s.charAt(curr);
            curr += cycle;
        }
        // System.out.println(new String(zigzag));
        for (int row = 1; row < numRows - 1; row++){
            int inc = cycle - 2 * row;
            curr = row;
            while (curr < n){
                // System.out.println("" + row + " " + curr + " " );
                zigzag[k++] = s.charAt(curr);
                curr += inc;
                inc = cycle - inc;
            }
        }
        // System.out.println(new String(zigzag));
        curr = numRows - 1;
        while(curr < n){
            // System.out.println("" + k + " " + curr + " " + n);
            zigzag[k++] = s.charAt(curr);
            curr += cycle;
        }
        return new String(zigzag);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String s = solution.convert("ABCD", 4);
        // System.out.println(s.length());
        System.out.println(s);
    }
}