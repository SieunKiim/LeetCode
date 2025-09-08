class Solution {
    public int[] getNoZeroIntegers(int n) {
        int original = n;
        int[] output = new int[2];
        int aa = 0;
        int tenCount = 0;
        while(n > 0){
            // System.out.println(aa);
            if(n%10 == 1){
                n -= 10;
                if(n> 0)
                    aa += (Math.pow(10,tenCount) *2);
                
            } else {
                aa += (Math.pow(10,tenCount));
                n-=1;
            }
            n = n/10;
            tenCount ++;
        }
        output[0] = aa;
        output[1] = original-aa;
        return output;
    }
}