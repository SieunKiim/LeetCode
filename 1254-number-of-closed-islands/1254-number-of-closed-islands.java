class Solution {
    
    int res;
    boolean[][] visited;
    int[] di = {0, -1, 0, 1};
    int[] dj = {-1, 0, 1, 0};
    int n;
    int m;
    
    public int closedIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        res = 0;
        visited = new boolean[n][m];
        for(int i = 1; i<n-1; i++){
            
            for(int j = 1; j <m-1; j++){
                if(grid[i][j] == 0 && !visited[i][j]) {
                    if(bfs(i,j, grid)) {
                        res += 1;
                        // System.out.println(i + " " + j);
                    }
                }
            }
        }
        return res;
    }
    
    public boolean bfs(int i, int j, int[][] grid){
        boolean output = true;;
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {i,j});
        while(!que.isEmpty()){
            int[] now = que.poll();
            visited[now[0]][now[1]] = true;
            for(int d = 0; d<4; d++){
                int ni = now[0] + di[d];
                int nj = now[1] + dj[d];
                if(0<= ni && ni < n && 0<= nj && nj < m && grid[ni][nj] == 0 && !visited[ni][nj]){
                    if(ni == 0 || ni == n-1 || nj == 0 || nj == m-1) output = false;
                    que.add(new int[] {ni,nj});
                }
            }
        }
        return output;
    }
    
}