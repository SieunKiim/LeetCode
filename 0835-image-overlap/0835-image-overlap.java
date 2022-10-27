class Solution {
    int result = 0;
    int n;
    public int largestOverlap(int[][] img1, int[][] img2) {
        n = img1.length;
        for(int row = -n+1; row < n ; row++){
            for(int col = -n+1; col < n ;col++){
                find(img1, img2, row, col);
            }
        }
        return result;
    }
    
    public void find(int[][] img1, int[][]img2, int row, int col){
        int count = 0;
        for(int i =0; i< n ; i++){
            for(int j =0; j<n; j++){
                int ni = i + row;
                int nj = j + col;
                if(0<= ni && ni < n && 0 <= nj && nj <n){
                    if(img1[ni][nj] == 1 && img2[i][j]== 1) count += 1;
                }
            }
        }
        result = Math.max(result, count);
    }
}