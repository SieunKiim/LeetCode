class Solution {
    static int n;
    static int m;
    static int[][] board;
    public int[][] diagonalSort(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        board = new int[n][m];
        int I = n-1;
        int J = 0;
        
        while (true){
            pp(I,J,mat);
            
            
            if (I!= 0){
                I-= 1;
            } else{
                J += 1;
            }
            if (J == m) break;
        }
        
        return board;
    }
    
    void pp(int I, int J, int[][] mat){
        int i = I;
        int j = J;
        int len = Math.min(n-i, m-j);
        int[] temp = new int[len];
        int index = 0;
        while(i<n && j<m){
            temp[index] = mat[i][j];
            index+=1;
            i+=1;
            j+=1;
        }
        Arrays.sort(temp);
        for(int t : temp){
            board[I][J] = t;
            I+=1;
            J+=1;
        }
        
    }
}