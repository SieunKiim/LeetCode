class Solution {
    public boolean isPowerOfFour(int n) {
        int tt= 1;
        while(tt > 0 && tt < n){
            tt *= 4;
        }
        return tt == n;
    }
}