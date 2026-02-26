class Solution {
    public int numSteps(String s) {
        int n = s.length()-1;
        boolean up = false;
        int count = 0;
        while(n >0){
            char now = s.charAt(n);
            if(up){
                now += 1;
                up = false;
            }

            if(now == '2'){
                up = true;
                now = '0';
            }

            count += 1;

            if(now == '1'){
                count += 1;
                up = true;
            }
            n-=1;
        }
        if (up) count += 1;
        return count;
    }
}