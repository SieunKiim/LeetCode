class Solution {
    
    int n;
    int m;
    int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    
    boolean[][][] visited;
    public int shortestPath(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m][k+1];
        Deque<int[]> que = new ArrayDeque<>();
        visited[0][0][k] = true;
        que.add(new int[]{0,0,0,k}); // i , j , dist, k
        while(!que.isEmpty()){
            int[] temp = que.poll();
            int ti = temp[0], tj = temp[1], dist = temp[2], tk = temp[3];
            if(ti == n-1 && tj == m-1) return dist;
            for(int d= 0; d<4; d++){
                int ni = ti + D[d][0];
                int nj = tj + D[d][1];
                if(ni<0 || n<= ni || nj <0 || m<= nj) continue;
                int nk = tk-grid[ni][nj];
                if(nk >=0 && !visited[ni][nj][nk]){
                    visited[ni][nj][nk] = true;
                    que.add(new int[] {ni,nj,dist+1, nk});
                }
            }
        }
        
        return -1;
    }
}