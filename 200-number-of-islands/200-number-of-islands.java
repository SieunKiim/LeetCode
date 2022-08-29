class Solution {
    class Point{
        int i;
        int j;
        Point (int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    int[] di = {-1, 0, 1, 0};
    int[] dj = {0, -1, 0, 1};
    
    public int numIslands(char[][] grid) {
        int count = 0;
        Queue<Point> que = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i<n;i ++){
            for (int j = 0; j <m;j++){
                if(grid[i][j] == '1'){
                    count += 1;
                    que.add(new Point(i,j));
                    grid[i][j] = '0';
                    while (!que.isEmpty()){
                        Point p = que.poll();
                        
                        for (int d= 0; d<4; d++){
                            int ni = p.i + di[d];
                            int nj = p.j + dj[d];
                            if(0<= ni && ni < n && 0<= nj && nj< m && grid[ni][nj] == '1'){
                                que.add(new Point(ni,nj));
                                grid[ni][nj] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}