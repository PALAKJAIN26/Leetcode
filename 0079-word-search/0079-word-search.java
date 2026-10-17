class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0) && dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // Base case: If we have matched all characters in the word
        if (index == word.length()) {
            return true;
        }
        
        // Check bounds and if the current cell matches the character
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        
        // Temporarily mark the cell as visited
        char temp = board[r][c];
        board[r][c] = '*';
        
        // Explore all 4 directions: Down, Up, Right, Left
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);
        
        // Restore the cell's original character (Backtrack)
        board[r][c] = temp;
        
        return found;
    }
}