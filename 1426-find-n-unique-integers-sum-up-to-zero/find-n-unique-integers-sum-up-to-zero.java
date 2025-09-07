class Solution {
    public int[] sumZero(int n) {
        int[] output= new int[n];
        
        for(int i = 0; i< n/2 ;i++){
            int num = i+1;
            output[i] = num;
            output[n-1-i] = -num;
        }
        return output;
    }
}