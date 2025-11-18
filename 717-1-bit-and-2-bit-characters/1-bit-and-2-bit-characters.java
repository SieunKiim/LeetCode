class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if(bits[n-1]== 1) return false;
        int i;
        for(i=0;i<n-1;i++){
            if(bits[i] == 1){
                i+=1;
            }
        }
        return i == n-1;
    }
}