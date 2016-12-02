import java.util.Stack;

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int height = grid.length;
        int width = grid[0].length;
        int[][] islands = new int[height][width];
        int ind = 0;
        Stack<Integer> stack = new Stack<>();
        for(int Y = 0; Y < height; Y++){
            for (int X = 0; X < width; X++){
                if (grid[Y][X] == '1' && islands[Y][X] == 0){
                    ind++;
                    stack.add(Y * width + X);
                    while(!stack.isEmpty()){
                        int cord = stack.pop();
                        int y = cord / width, x = cord % width;
                        islands[y][x] = ind;
                        // System.out.println("abc");
                        if (y > 0 && grid[y - 1][x] == '1' && islands[y - 1][x] == 0)
                            stack.push((y - 1) * width + x);
                        if (y < height - 1 && grid[y + 1][x] == '1' && islands[y + 1][x] == 0)
                            stack.push((y + 1) * width + x);
                        if (x > 0 && grid[y][x - 1] == '1' && islands[y][x - 1] == 0)
                            stack.push(y * width + x - 1);
                        if (x < width - 1 && grid[y][x + 1] == '1' && islands[y][x + 1] == 0)
                            stack.push(y * width + x + 1);
                    }
                }
            }
        }
        return ind;
    }
}