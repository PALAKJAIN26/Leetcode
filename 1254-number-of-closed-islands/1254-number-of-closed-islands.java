class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j, m, n)) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean dfs(int[][] grid, int r, int c, int m, int n) {
        // If the current cell is out of bounds, the island touches the boundary (not closed)
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return false;
        }
        
        // If it's water (1) or already visited, it's valid for this path
        if (grid[r][c] == 1) {
            return true;
        }
        
        // Mark the current land cell as visited by turning it into water (1)
        grid[r][c] = 1;
        
        // Explore all 4 directions
        boolean left = dfs(grid, r, c - 1, m, n);
        boolean right = dfs(grid, r, c + 1, m, n);
        boolean up = dfs(grid, r - 1, c, m, n);
        boolean down = dfs(grid, r + 1, c, m, n);
        
        // The island is closed only if all directions are valid / closed
        return left && right && up && down;
    }
}