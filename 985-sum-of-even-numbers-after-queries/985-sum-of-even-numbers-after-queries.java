class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        int index = 0;
        int evenSum = 0;
        for(int n : nums){
            if(n%2 == 0) {
                evenSum += n;
            }
        }
        for(int[] q : queries){
            int temp = nums[q[1]] + q[0];
            
            if(temp%2 == 0){
                if(nums[q[1]]%2 == 0) evenSum += q[0];
                else {
                    evenSum += temp;
                }
            }else{
                if(nums[q[1]]%2 == 0) evenSum -= nums[q[1]];
            }
            result[index] = evenSum;
            nums[q[1]] = temp;
            index +=1;
        }
        return result;
    }
}