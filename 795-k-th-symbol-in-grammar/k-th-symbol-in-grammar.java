import java.util.*;

class Solution {
    public int kthGrammar(int n, int k) {
        int num = (int)Math.pow(2, n-1) + (k-1);
        int count = 0;
        while(num > 1){
            if(num %2 != 0) count += 1;
            num /=2;
        }
        return count%2;
    }
}