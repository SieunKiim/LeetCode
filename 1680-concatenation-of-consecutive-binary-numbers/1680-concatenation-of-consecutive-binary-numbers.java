class Solution {
    public int concatenatedBinary(int n) {
        long result = 0;
        for(int i = 1; i <= n ; i++){
            int len = Integer.toBinaryString(i).length();
            result = ((result << len) + i) % 1000000007;
        }
        return (int) result;
    }
}