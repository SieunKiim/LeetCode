class Solution {
    public int numberOfMatches(int n) {
        int count = 0;
        while(n > 1){
            int temp= n/2;
            n -= temp;
            count +=temp;
        }
        return count;
    }
}