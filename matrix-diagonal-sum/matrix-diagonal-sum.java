class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int total = 0;
        for(int i = 0; i<n ;i++){
            total += (mat[i][i] + mat[n-1-i][i]);
        }

        if(n%2 == 1){
            total -= mat[n/2][n/2];
        }
        return total;
    }
}