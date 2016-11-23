public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] xStart = new int[27];
        int[] yStart = new int[27];
        int[] dx = {1, 9, 3};
        int[] dy = {9, 1, 3};
        for (int i = 0; i < 9; i++){
            xStart[i] = i;
            yStart[9 + i] = i;
            xStart[18 + i] = (i / 3) * 3;
            yStart[18 + i] = (i % 3) * 3;
        }
        for (int i = 0; i < 27; i++){
            boolean[] visited = new boolean[9];
            int x0 = xStart[i];
            int y0 = yStart[i];
            System.out.println("x0: " + x0 + " y0: " + y0);
            for(int x = x0; x < x0 + dx[i / 9]; x++){
                for (int y = y0; y < y0 + dy[i / 9]; y++){
                    char ch = board[y][x];
                    if (ch == '.')
                        continue;
                    System.out.println("x: " + x + " y: " + y);
                    int k = ch - '1';
                    if (visited[k])
                        return false;
                    else
                        visited[k] = true;
                }
            }
        }
        return true;
    }

    public char[][] createBoard(String[] args){
        char[][] board = new char[9][];
        for (int i = 0; i < 9; i++)
            board[i] = args[i].toCharArray();
        return board;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String[] s = {".........","......3..","...18....","...7.....","....1.97.",".........","...36.1..",".........",".......2."};
        for (String ss : s)
            System.out.println(ss);

        char[][] board = solution.createBoard(s);
        System.out.println(solution.isValidSudoku(board));
    }
}