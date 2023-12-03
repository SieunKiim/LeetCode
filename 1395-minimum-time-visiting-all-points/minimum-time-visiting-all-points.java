import java.util.*;

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {

        int n = points.length;
        if(n == 0) return 0;
        int res = 0;
        int lastX = points[0][0];
        int lastY = points[0][1];
        for (int i = 1; i < n; i++) {
            int[] point = points[i];
            int x = point[0];
            int y = point[1];
            res += Math.max(Math.abs(x - lastX), Math.abs(y - lastY));
            lastY = y;
            lastX = x;
        }
        return res;
    }
}