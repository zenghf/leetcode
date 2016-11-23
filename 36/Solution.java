public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++){
            boolean[] visited = new boolean[9];
            for (int j = 0; j < 9; j++){
                char ch = board[i][j];
                if (ch != '.'){
                    if (visited[ch - '1'])
                        return false;
                    else
                        visited[ch - '1'] = true;
                }
            }
        }

        for (int i = 0; i < 9; i++){
            boolean[] visited = new boolean[9];
            for (int j = 0; j < 9; j++){
                char ch = board[j][i];
                if (ch != '.'){
                    if (visited[ch - '1'])
                        return false;
                    else
                        visited[ch - '1'] = true;
                }
            }
        }

        for (int i = 0; i < 9; i++){
            boolean[] visited = new boolean[9];
            int x0 = (i / 3) * 3;
            int y0 = (i % 3) * 3;
            for (int j = 0; j < 9; j++){
                char ch = board[x0 + j / 3][y0 + j % 3];
                if (ch != '.'){
                    if (visited[ch - '1'])
                        return false;
                    else
                        visited[ch - '1'] = true;
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
        String[] s = {"..4...63.",".........","5......9.","...56....","4.3.....1","...7.....","...5.....",".........","........."};
        for (String ss : s)
            System.out.println(ss);

        char[][] board = solution.createBoard(s);
        System.out.println(solution.isValidSudoku(board));
    }
}