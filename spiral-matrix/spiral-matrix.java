class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        int d = 0;
        int i = 0;
        int j = 0;
        ArrayList<Integer> output = new ArrayList<>();
        while(true){
             if (i >= n || i < 0 || j >= m || j < 0 ||visited[i][j]) break;
            visited[i][j] = true;
            output.add(matrix[i][j]);
            int ni = i + direction[d][0];
            int nj = j + direction[d][1];
            if(ni >= n || ni<0 || nj >= m || nj <0 || visited[ni][nj]){
                d = (d+1)%4;
            }
            i = i + direction[d][0];
            j = j + direction[d][1];
        }
        return output;
    }
}