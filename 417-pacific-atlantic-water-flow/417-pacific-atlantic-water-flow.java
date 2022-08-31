class Solution {
    int n;
    int m;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<int[]> pQue = new LinkedList<>();
        Queue<int[]> aQue = new LinkedList<>();
        boolean[][] pVisited = new boolean[n][m];
        boolean[][] aVisited = new boolean[n][m];
        
        for (int i = 0; i< n; i++){
            pQue.add(new int[] {i,0});
            aQue.add(new int[] {i,m-1});
            pVisited[i][0] = true;
            aVisited[i][m-1] = true;
        }
        for (int j = 0; j<m;j++){
            pQue.add(new int[] {0,j});
            aQue.add(new int[] {n-1,j});
            pVisited[0][j] = true;
            aVisited[n-1][j] = true;
        }
        
        bfs(heights, pQue, pVisited);
        bfs(heights, aQue, aVisited);
        
        
        
        for (int i =0; i < n; i++){
            for(int j = 0; j<m; j++){
                if(pVisited[i][j] && aVisited[i][j]){
                    result.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        
        return result;
        
    }
    
    int[] di = {-1,0,1,0};
    int[] dj = {0,-1, 0, 1};
    public void bfs(int[][] board, Queue<int[]> que, boolean[][] visited){
        int n = board.length;
        int m = board[0].length;
        while(!que.isEmpty()){
            int[] temp = que.poll();
            for(int d = 0; d<4; d++){
                int ni = temp[0]+di[d];
                int nj = temp[1] + dj[d];
                if(0<= ni && ni < n && 0<= nj && nj<m && visited[ni][nj] == false && board[ni][nj] >= board[temp[0]][temp[1]]){
                    visited[ni][nj] = true;
                    que.add(new int[]{ni,nj});
                }
            }
        }
    }
}