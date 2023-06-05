class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int[] point = coordinates[0];
        double gradi = getGradi(coordinates[0], coordinates[1]);
        for(int i = 2; i< coordinates.length;i++){
            if(getGradi(point, coordinates[i]) != gradi) return false;
        }
        return true;
    }

    public double getGradi(int[] a, int[] b){
        if(a[0] - b[0] == 0) return Double.MAX_VALUE;
        return ((a[1] - b[1] + 0.0) / (a[0] - b[0]) + 0.0);
    }
}