class Solution {
    public int uniquePathsWithObstacles(int[][] map) {
        int n = map.length;
        int m = map[0].length;

        int[][] D = new int[][] {{0,1},{1,0}};
        int[][] target = new int[n][m];
        
        if(map[0][0] != 1) target[0][0] = 1;

        for(int i =0 ; i<n;i++){
            for(int j = 0; j<m; j++){
                for(int d = 0; d<2;d++){
                    int ni = i + D[d][0];
                    int nj = j + D[d][1];
                    if( ni < n && nj < m && map[ni][nj] == 0){
                        target[ni][nj] += target[i][j];
                    }
                }
            }
        }
        return target[n-1][m-1];
    }
}