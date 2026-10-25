class Solution {
    private int m, n;

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // 1. Eliminate all lands (0) connected to the grid boundary
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (grid[i][j] == 0) {
                        dfs(grid, i, j);
                    }
                }
            }
        }

        // 2. Count remaining closed islands
        int closedIslandsCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    closedIslandsCount++;
                    dfs(grid, i, j);
                }
            }
        }

        return closedIslandsCount;
    }

    private void dfs(int[][] grid, int r, int c) {
        // Base case: check boundaries and water (1)
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 1) {
            return;
        }

        // Mark current land as visited by turning it into water (1)
        grid[r][c] = 1;

        // Explore all 4 directions
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
