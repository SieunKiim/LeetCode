class Solution {
    int n;
    public int maximumScore(int[] nums, int k) {
        n = nums.length;
        int output = nums[k];

        int leftIndex = k, rightIndex = k;
        int leftValue = nums[k], rightValue = nums[k], minNum = nums[k];

        while (leftAble(leftIndex) || rightAble(rightIndex)) {
            if ((leftIndex > 0 ? nums[leftIndex-1]: 0) > (rightIndex < n-1 ? nums[rightIndex+1]: 0)) {
                leftIndex--;
                leftValue = nums[leftIndex];
                minNum = Math.min(minNum, leftValue);
            } else {
                rightIndex++;
                rightValue = nums[rightIndex];
                minNum = Math.min(minNum, rightValue);
            }
            output = Math.max(minNum * getMultiple(leftIndex, rightIndex), output);
        }
        return output;
    }

    private int getMultiple(int i, int j){
        return j - i + 1;
    }

    private boolean leftAble(int left) {
        return left > 0;
    }

    private boolean rightAble(int right) {
        return right < n - 1;
    }
}