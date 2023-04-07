class Solution {
    
    int res;
    boolean[][] visited;
    int[] di = {0, -1, 0, 1};
    int[] dj = {-1, 0, 1, 0};
    int n;
    int m;
    
    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        res = 0;
        visited = new boolean[n][m];
        for(int i = 1; i<n-1; i++){

            for(int j = 1; j <m-1; j++){
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int temp = bfs(i,j, grid);
                    if(temp != 0) {
                        res += temp;
                        // System.out.println(i + " " + j +" temp : "+temp);
                    }
                }
            }
        }
        return res;
    }
    
    public int bfs(int i, int j, int[][] grid){
        boolean output = true;
        int count = 0;
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[] {i,j});
        visited[i][j] = true;
        while(!que.isEmpty()){
            int[] now = que.poll();
            count += 1;
            
            for(int d = 0; d<4; d++){
                int ni = now[0] + di[d];
                int nj = now[1] + dj[d];
                if(0<= ni && ni < n && 0<= nj && nj < m && grid[ni][nj] == 1 && !visited[ni][nj]){
                    if(ni == 0 || ni == n-1 || nj == 0 || nj == m-1) output = false;
                    visited[ni][nj] = true;
                    que.add(new int[] {ni,nj});
                }
            }
        }
        if (output) return count;
        return 0;
    }
}


// [0,0,0,1,1,1,0,1,1,1,1,1,0,0,0],
// [1,1,1,1,0,0,0,1,1,0,0,0,1,1,1],
// [1,1,1,0,0,1,0,1,1,1,0,0,0,1,1],
// [1,1,0,1,0,1,1,0,0,0,1,1,0,1,0],
// [1,1,1,1,0,0,0,1,1,1,0,0,0,1,1],
// [1,0,1,1,0,0,1,1,1,1,1,1,0,0,0],
// [0,1,0,0,1,1,1,1,0,0,1,1,1,0,0],
// [0,0,1,0,0,0,0,1,1,0,0,1,0,0,0],
// [1,0,1,0,0,1,0,0,0,0,0,0,1,0,1],
// [1,1,1,0,1,0,1,0,1,1,1,0,0,1,0]