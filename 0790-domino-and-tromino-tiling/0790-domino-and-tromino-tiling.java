class Solution {
    public int numTilings(int n) {
        if(n <= 2)
            return n;
        
        int mod = 1_000_000_007;
        long[] fullTiling = new long[n+1];
        long[] partTiling = new long[n+1];
        
        // One tile vertical can fill a pair of cells (or 1 column)
        fullTiling[1] = 1;
        // 2 vertical and 2 horizontals can fill up 2 pair of cells (or 2 columns)
        fullTiling[2] = 2; 
        
        // Cannot fill one cell (in a column) with either domino or tromino
        partTiling[1] = 0; 
        // If 1 cell out of 4 (2 pair of cells) is already filled then a tromino can fill the remaining 3 cells
        partTiling[2] = 1; 
        
        for(int i=3; i <= n; i++){
            fullTiling[i] = (fullTiling[i-1] + fullTiling[i-2] + 2 * partTiling[i-1]) % mod;
            partTiling[i] = (partTiling[i-1] + fullTiling[i-2]) % mod;
        }        
        return (int)(fullTiling[n]);
    }
}
