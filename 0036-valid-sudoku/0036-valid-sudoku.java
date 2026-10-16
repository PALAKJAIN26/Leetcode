import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char current = board[r][c];
                if (current == '.') {
                    continue;
                }

                // Construct unique identifiers for row, column, and 3x3 sub-box
                String rowKey = r + " in row " + current;
                String colKey = c + " in col " + current;
                String boxKey = (r / 3) * 3 + (c / 3) + " in box " + current;

                // If any of these already exist, the Sudoku is invalid
                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        return true;
    }
}