class Solution {
    static final int INF = 1000000000;
    int rows = 0, cols = 0, maxval = 0;

    void dp_iteration(int[][] dp, int[] best_teleport, int[][] grid) {
        for (int r = rows - 1; r >= 0; --r) {
            for (int c = cols - 1; c >= 0; --c) {
                int walk = ((r != rows - 1) || (c != cols - 1)) ? INF : 0;
                if (r + 1 < rows) walk = Math.min(walk, dp[r + 1][c] + grid[r + 1][c]);
                if (c + 1 < cols) walk = Math.min(walk, dp[r][c + 1] + grid[r][c + 1]);
                dp[r][c] = Math.min(walk, best_teleport[grid[r][c]]);
            }
        }
    }

    int[] build_teleport(int[][] dp, int[][] grid) {
        int[] teleport = new int[maxval + 1];
        for (int i = 0; i <= maxval; ++i) teleport[i] = INF;

        // First build mincost for each v = value
        for (int r = 0; r < rows; ++r)
            for (int c = 0; c < cols; ++c)
                teleport[grid[r][c]] = Math.min(teleport[grid[r][c]], dp[r][c]);

        // Then build prefix mincost for v <= value
        for (int v = 0; v <= maxval; ++v)
            teleport[v] = Math.min(teleport[v], v > 0 ? teleport[v - 1] : INF);

        return teleport;
    }

    public int minCost(int[][] grid, int k) {
        rows = grid.length; cols = grid[0].length;
        maxval = 0;
        for (int r = 0; r < rows; ++r)
            for (int c = 0; c < cols; ++c)
                if (grid[r][c] > maxval) maxval = grid[r][c];

        int[] best_teleport = new int[maxval + 1];
        for (int i = 0; i <= maxval; ++i) best_teleport[i] = INF;

        int[][] dp = new int[rows][cols];
        for (int r = 0; r < rows; ++r)
            for (int c = 0; c < cols; ++c)
                dp[r][c] = INF;

        dp[rows - 1][cols - 1] = 0; // zero cost to reach dest from dest

        for (int t = 0; t <= k; ++t) { // t teleports allowed
            dp_iteration(dp, best_teleport, grid);
            best_teleport = build_teleport(dp, grid);
        }

        return dp[0][0];
    }
}