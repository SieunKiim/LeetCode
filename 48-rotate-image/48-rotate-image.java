class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int top = 0;
        int left = 0;
        int bottom = n-1;
        int right = n-1;
        while(left<right && top < bottom){
            int[] topArr = Arrays.copyOfRange(matrix[top],left, right+1);
            int[] bottomArr = Arrays.copyOfRange(matrix[bottom], left,right+1);
            int[] leftArr = new int[bottom-top-1];
            int[] rightArr = new int[bottom-top-1];
            
            for(int i = top+1; i<bottom;i++ ){
                leftArr[i-top-1] = matrix[i][left];
                rightArr[i-top-1] = matrix[i][right];
            }
            // System.out.println(Arrays.toString(topArr));
            // System.out.println(Arrays.toString(bottomArr));
            // System.out.println(Arrays.toString(leftArr));
            // System.out.println(Arrays.toString(rightArr));
            // System.out.println("-----------");
//             ///
            for(int i = top; i < bottom+1; i++){
                matrix[i][right] = topArr[i-top];
                matrix[i][left] = bottomArr[i-top];
            }
            
            for (int i = right-1; i >left ; i--){
                matrix[top][i] = leftArr[(right-1-i)];
                matrix[bottom][i] = rightArr[right-1-i];
            }
            
            
            
            
            
            top += 1;
            bottom -= 1;
            left += 1;
            right -= 1;
        }
    }
}