class Solution {
    char[][] map;
    int[][] D = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int n;
    int m;
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        map = grid;
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        visited = new boolean[n][m];
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i,j);
                    count += 1;
                            // System.out.println("count  :: i : " + i + " j : " + j);
                };
                visited[i][j] = true;
            }
        }
        return count;
    }

    private void dfs(int i , int j){
        // System.out.println("i : " + i + " j : " + j);
        visited[i][j] =true;
         for(int d=0; d<4;d++){
            int ni = D[d][0] + i;
            int nj = D[d][1] + j;
            if(canGo(ni, nj) && !visited[ni][nj] && map[ni][nj] == '1'){
                dfs(ni,nj);
            }
        }
    }

    private boolean canGo(int i, int j){
        return 0<= i  && i< n && 0<= j && j< m;
    }
}