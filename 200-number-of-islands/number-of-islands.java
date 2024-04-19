class Solution {

    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, -1, 0, 1};


    public boolean[][] visited;
    public char[][] map;
    public int n;
    public int m;


    public int numIslands(char[][] grid) {
        int islandCount = 0;
        n = grid.length;
        m = grid[0].length;
        map = grid;

        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j);
                    islandCount += 1;
                }
            }
        }
        return islandCount;
    }

    public void dfs(int x, int y) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == '1' && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }


}