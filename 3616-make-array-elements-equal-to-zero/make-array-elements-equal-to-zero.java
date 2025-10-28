class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] sumArr = new int[n];
        sumArr[0] = nums[0];
        for(int i=1;i<n;i++){
            sumArr[i] = sumArr[i-1] + nums[i];
        }
        // System.out.println(Arrays.toString(sumArr));
        int output = 0;
        for(int i =0 ;i<n;i++){
            if(nums[i] != 0) continue;

            int leftSum = sumArr[i];
            int rightSum = sumArr[n-1] - sumArr[i];
            // System.out.println("index : " + i + ", leftSum : " + leftSum + ", rightSum : " + rightSum);
            if(leftSum == rightSum) output += 2;
            if(Math.abs(leftSum-rightSum) == 1) output += 1;
        }
        return output;
    }
}