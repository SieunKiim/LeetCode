class Solution {
    
    int[][] D = {{0,1},{0,-1},{1,0},{-1,0}};
    int totalBlock;
    int paths;
    int[] start = {-1,-1};
    int[] end = {-1,-1};
    int[][] map;
    boolean[][] visited;
    int n;
    int m;
    
    public int uniquePathsIII(int[][] grid) {
        totalBlock = 0;
        paths = 0;
        map = grid;
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length;j++){
                int block = grid[i][j];
                if(block == 0) totalBlock += 1;
                else if(block == 1) {
                    start[0] = i;
                    start[1] = j;
                }
                else if (block == 2) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        dfs(start, 0);
        return paths;
    }
    
    public void dfs(int[] now, int count){
        
        visited[now[0]][now[1]] = true;
        count += 1;
        
        
        if(map[now[0]][now[1]] == 2 && count == totalBlock+2){
            paths+=1;
            visited[now[0]][now[1]] = false;
            count -= 1;
            return;
        }
        
        for(int d = 0; d < 4; d++){
            int ni = now[0] + D[d][0];
            int nj = now[1] + D[d][1];
            if(0<= ni &&  ni < n && 0 <= nj && nj < m && !visited[ni][nj] && map[ni][nj] != -1){
                dfs(new int[] {ni,nj}, count);
            }
        }
        
        
        visited[now[0]][now[1]] = false;
        count -= 1;
    }
}