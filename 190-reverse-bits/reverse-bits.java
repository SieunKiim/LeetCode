class Solution {
    public int reverseBits(int n) {
        int output = 0;
        for (int i = 0; i < 32; i++) {
            output = (output << 1) | (n & 1);
            n >>>= 1;
        }
        return output;
    }
}