class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(grid, i, j, m, n)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean dfs(int[][] grid, int r, int c, int m, int n) {
        if (r < 0 || r >= m || c < 0 || c >= n) return false;
        if (grid[r][c] == 1) return true;

        grid[r][c] = 1;

        boolean a = dfs(grid, r + 1, c, m, n);
        boolean b = dfs(grid, r - 1, c, m, n);
        boolean d = dfs(grid, r, c + 1, m, n);
        boolean e = dfs(grid, r, c - 1, m, n);

        return a && b && d && e;
    }
}