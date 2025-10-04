class Solution {

    public int maxArea(int[] height) {
        int output = 0;
        int n = height.length;
        int leftIndex = 0;
        int rightIndex = n-1;
        while(leftIndex < rightIndex){
            output = Math.max(output,(rightIndex-leftIndex) * Math.min(height[rightIndex], height[leftIndex]));
            // System.out.println("leftIndex : " + leftIndex + " rightIndex : " + rightIndex);
            if(height[rightIndex]<= height[leftIndex]){
                rightIndex -= 1;
                // leftIndex += 1;
            } else {
                leftIndex += 1;
                // rightIndex -= 1;
            }
        }
        return output;
    }
}