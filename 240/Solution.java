public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;
        int height = matrix.length;
        int width = matrix[0].length;
        return searchMatrix(matrix, target, 0, 0, height - 1, width - 1);

    }

    public boolean searchMatrix(int[][] matrix, int target, int y1, int x1, int y2, int x2) {
        if (y1 > y2 || x1 > x2)
            return false;
        if (target < matrix[y1][x1])
            return false;
        if (target > matrix[y2][x2])
            return false;
        int midx = (x1 + x2) / 2;
        int midy = (y1 + y2) / 2;
        int m = matrix[midy][midx];
        if (target == m)
            return true;
        else if (target < m){
            return searchMatrix(matrix, target, y1, x1, midy - 1, midx - 1) ||
                   searchMatrix(matrix, target, midy, x1, y2, midx - 1) ||
                   searchMatrix(matrix, target, y1, midx, midy - 1, x2);
        }
        else
            return searchMatrix(matrix, target, midy + 1, midx + 1, y2, x2) ||
                   searchMatrix(matrix, target, midy + 1, x1, y2, midx) ||
                   searchMatrix(matrix, target, y1, midx + 1, midy, x2);

    }
}