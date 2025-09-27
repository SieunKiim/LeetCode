class Solution {
    public double largestTriangleArea(int[][] points) {
        double output = 0;
        for(int i =0;i < points.length;i++){
            for(int j = i+1; j < points.length;j++){
                for(int k = j+1; k<points.length;k++){
                    output = Math.max(output, getSize(points[i], points[j], points[k]));
                }
            }
        }
        return output;
    }

    private double getSize(int[] A, int[] B, int[] C){
        int a = A[0] * B[1] + B[0] * C[1] + C[0] * A[1];
        int b=  A[1] * B[0] + B[1] * C[0] + C[1] * A[0];
        return (Math.abs(a-b) + 0.0) / 2.0;
    }
}