import java.util.*;
class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int a = Math.abs(sx-fx);
        int b = Math.abs(sy-fy);
        int big = Math.max(a,b);
        int small  = Math.min(a,b);

        if(big == 0) return t != 1;
        return t >= big;
    }
}