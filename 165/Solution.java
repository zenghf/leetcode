public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++){
            int n1 = 0, n2 = 0;
            if (i < v1.length)
                n1 = Integer.parseInt(v1[i]);
            if (i < v2.length)
                n2 = Integer.parseInt(v2[i]);
            if (n1 > n2)
                return 1;
            if (n1 < n2)
                return -1;
        }
        return 0;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.compareVersion("1.2", "2.3");
    }
}