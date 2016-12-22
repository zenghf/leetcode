import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<Integer>();
        int height = matrix.length;
        int width = matrix[0].length;
        int n = height * width;
        ArrayList<Integer> result = new ArrayList<>(n);
        if (width == 1){
            for(int[] row : matrix)
                result.add(row[0]);
            return result;
        }
        // System.out.println("height: " + height + " width: " + width);
        int hmin = 1, hmax = height - 1, wmin = 0, wmax = width - 1;
        int h = 0, w = 0, direction = 0;
        for (int i = 0; i < n; i++){
            // System.out.println(""+h+w);
            result.add(matrix[h][w]);

            if (direction == 0){
                w++;
                if (w == wmax){
                    direction++;
                    wmax--;
                }
            }
            else if(direction == 1){
                h++;
                if (h == hmax){
                    direction++;
                    hmax--;
                }
            }
            else if(direction == 2){
                w--;
                if(w == wmin){
                    direction++;
                    wmin++;
                }
            }
            else{
                h--;
                if(h == hmin){
                    direction = 0;
                    hmin++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        // int[][] matrix = {{1,2,3,10},{4,5,6,11},{7,8,9,12}};
        int[][] matrix = {{1},{2}};
        Solution solution = new Solution();
        List<Integer> result = solution.spiralOrder(matrix);
        for(int num : result){
            System.out.println(" " + num);
        }
    }
}