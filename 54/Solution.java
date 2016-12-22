import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<Integer>();
        int height = matrix.length;
        int width = matrix[0].length;
        // System.out.println("height: " + height + " width: " + width);
        int n = height * width;
        int minLength = Math.min(height, width);
        int nLoop = minLength / 2;
        ArrayList<Integer> result = new ArrayList<>(n);
        int hmin = 0, hmax = height - 1, wmin = 0, wmax = width - 1;
        int h = 0, w = -1;
        // result.add(matrix[h][w]);
        for (int i = 0; i < nLoop; i++){
            // System.out.println("h = " + h + " w from " + w + " to " + wmax);
            for(; w < wmax; w++)
                result.add(matrix[h][w + 1]);
            hmin++;
            // System.out.println("w = " + w + " h from " + h + " to " + hmax);
            for(; h < hmax; h++)
                result.add(matrix[h + 1][w]);
            wmax--;
            for(; w > wmin; w--)
                result.add(matrix[h][w - 1]);
            hmax--;
            for(; h > hmin; h--)
                result.add(matrix[h - 1][w]);
            wmin++;
        }
        if (minLength % 2 == 1){
            if (minLength == height){
                for(; w < wmax; w++)
                    result.add(matrix[h][w + 1]);
            }
            else{
                w++;
                result.add(matrix[h][w]);
                for(; h < hmax; h++)
                    result.add(matrix[h + 1][w]);
            }
        }
        return result;
    }

    public static void main(String[] args){
        // int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2}};
        Solution solution = new Solution();
        List<Integer> result = solution.spiralOrder(matrix);
        for(int num : result){
            System.out.println(" " + num);
        }
    }
}