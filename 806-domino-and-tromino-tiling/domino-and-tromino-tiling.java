import java.util.*;

class Solution {
    
    private final int mod = 1000000007;

    public int numTilings(int n) {
        //a[n] = (a[n-1]) + (a[n-2]) + (a[n-3] * 2)
        int[] a = new int[Math.max(4, n+1)];
        a[0] = 1;
        a[1] = 1;
        a[2] = 2;
        // a[3] = 5;
        // a[4] = 11;
        for(int i = 3; i<= n ;i++){
            a[i] = (a[Math.max(0, i-1)] * 2 % mod + (a[Math.max(0, i-3)]) % mod) %mod;
            // System.out.println(a[i]);
        }
        return a[n];
    }
}

// 1
// 2
// 5
// 11