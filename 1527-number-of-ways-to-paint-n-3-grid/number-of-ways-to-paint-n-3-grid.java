class Solution {
    int mod = 1000000007;
    public int numOfWays(int n) {
        long aba = 6;
        long abc = 6;
        
        while(n > 1){
            long tempABA = (aba * 3 + abc * 2) % mod;
            long tempABC = (aba * 2 + abc * 2) % mod;
            aba = tempABA;
            abc = tempABC;
            n--;
        }
        
        return (int)((aba + abc) % mod);
    }
}