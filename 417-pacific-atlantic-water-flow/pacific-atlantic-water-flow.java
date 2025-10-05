class Solution {
    List<List<Integer>> output;
    int n;
    int m;

    int[][] D = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        output = new ArrayList<>();

        Deque<List<Integer>> a = new ArrayDeque<>();
        for(int i = 0; i< n;i ++){
            a.add(Arrays.asList(i,0));
        }
        for(int j = 1;j<m;j++){
            a.add(Arrays.asList(0,j));
        }

        Deque<List<Integer>> b = new ArrayDeque<>();
        for(int i = 0; i< n;i ++){
            b.add(Arrays.asList(i,m-1));
        }
        for(int j = 0;j<m-1;j++){
            b.add(Arrays.asList(n-1,j));
        }

        boolean[][] visitedP = new boolean[n][m];
        boolean[][] visitedA = new boolean[n][m];

        bfs(heights,visitedP, a);
        bfs(heights,visitedA, b);

        for(int i = 0;i<n;i++){
            for(int j = 0;j <m;j++){
                if(visitedP[i][j] && visitedA[i][j]){
                    output.add(Arrays.asList(i,j));
                }
            }
        }
        return output;
    }

    private void bfs(int[][] map,boolean[][] visit, Deque<List<Integer>> points){

        while(!points.isEmpty()) {
            List<Integer> point = points.poll();
            int i = point.get(0);
            int j = point.get(1);
            visit[i][j] = true;
            for(int d= 0;d<4;d++){
                int ni = i + D[d][0];
                int nj = j + D[d][1];
                if(isPossible(ni,nj) && !visit[ni][nj] && map[i][j] <= map[ni][nj]){
                    points.add(Arrays.asList(ni,nj));
                }
            }
        }
    }

    private boolean isPossible(int i, int j){
        return 0<= i && i<n && 0<=j && j < m;
    }
}