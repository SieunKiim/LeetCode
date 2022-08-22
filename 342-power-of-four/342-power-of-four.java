
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n<=0){
            return false;
        }
        for(int i = 0; i<16; i++){
            if(n == Math.pow(4,i)){
                return true;
            }
        }
        return false;
    }
}