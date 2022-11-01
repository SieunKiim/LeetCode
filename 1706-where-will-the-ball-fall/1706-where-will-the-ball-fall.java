class Solution {
    int[][] map;
    int n;
    int m;
    public int[] findBall(int[][] grid) {
        map = grid;
        n = grid.length;
        m = grid[0].length;
        int[] result = new int[m];
        for(int j = 0; j<m;j++){
            result[j] = findPath(j);
        }
        return result;
    }
    
    public int findPath(int j){
        for(int i= 0; i <n; i++){
            if(map[i][j]== 1){
                if(j == m-1 || map[i][j+1] == -1){
                    return -1;
                } else {
                    j +=1;
                }
            } else{
                if(j == 0 || map[i][j-1] == 1){
                    return -1;
                }
                else{
                    j -=1;
                }
            }
        }
        return j;
    }
}