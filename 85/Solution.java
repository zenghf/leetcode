import java.util.HashMap;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int height = matrix.length, width = matrix[0].length;
        HashMap<Integer, HashMap<Integer, Integer>> table = new HashMap<>();
        for (int h = 0; h < height; h++){
            for (int w = 0; w < width; w++){
                if (matrix[h][w] == '0')
                    continue;
                // System.out.println("" + h + w);
                int ind = h * width + w;
                HashMap<Integer, Integer> dic = getDic(table, ind);
                for(int dw = 0; w + dw < width && matrix[h][w + dw] == '1'; dw++){
                    Integer dh = dic.get(dw);
                    if (dh == null)
                        dh = 0;
                    // System.out.println("dw dh: " + dw + dh);
                    boolean rowOK = true;
                    while(rowOK && dh + h + 1 < height){
                        for(int i = 0; i <= dw; i++){
                            if (matrix[dh + h + 1][w + i] == '0'){
                                rowOK = false;
                                break;
                            }
                            // System.out.println("-" + (dh + h + 1) + (w + i));
                        }
                        if (rowOK)
                            dh++;
                    }
                    // System.out.println("h w, dh dw : "  + h + w + dh + dw + " ** " + (dh + 1) * (dw + 1));
                    if ((dh + 1) * (dw + 1) > maxArea)
                        maxArea = (dh + 1) * (dw + 1);
                    for (int i = 1; i <= dh; i++)
                        getDic(table, ind + i * width).put(dw, dh - i);
                }
            }
        }
        return maxArea;
    }

    private HashMap<Integer, Integer> getDic(HashMap<Integer, HashMap<Integer, Integer>> table, int ind){
        HashMap<Integer, Integer> dic = table.get(ind);
        if (dic == null){
            dic = new HashMap<Integer, Integer>();
            table.put(ind, dic);
        }
        return dic;
    }

    public static void main(String[] args){
        String[] mat = {"10100","10111","11111","10010"};
        char[][] matrix = new char[mat.length][];
        for (int i = 0; i < mat.length; i++)
            matrix[i] = mat[i].toCharArray();
        for (int i = 0; i < mat.length; i++)
            System.out.println(mat[i]);
        Solution solution = new Solution();
        int area = solution.maximalRectangle(matrix);
        System.out.println("area: " + area);
    }
}