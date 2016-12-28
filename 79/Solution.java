
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        if (word == null || word.length() == 0)
            return true;
        int n = word.length();
        int height = board.length;
        int width = board[0].length;
        Stack<Integer> stack = new Stack<>();
        for (int h = 0; h < height; h++){
            for (int w = 0; w < width; w++){
                if (board[h][w] != word.charAt(0))
                    continue;
                if (exist(board, word, h, w, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, int h, int w, int k){
        if (k == word.length())
            return true;
        if (h < 0 || h >= board.length || w < 0 || w >= board[0].length)
            return false;
        if (board[h][w] != word.charAt(k))
            return false;
        board[h][w] ^= 256;
        boolean result = exist(board, word, h + 1, w, k + 1) ||
               exist(board, word, h - 1, w, k + 1) ||
               exist(board, word, h, w + 1, k + 1) ||
               exist(board, word, h, w - 1, k + 1);
        board[h][w] ^= 256;
        return result;
    }
}