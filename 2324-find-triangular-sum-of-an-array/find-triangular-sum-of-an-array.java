class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        int[] arr1 = Arrays.copyOf(nums, nums.length);
        
        while(arr1.length > 1){
            int[] arr2 = new int[arr1.length-1];
            for(int i= 0;i< arr1.length-1;i++){
                arr2[i] = (arr1[i] + arr1[i+1])%10;
            }
            arr1 = Arrays.copyOf(arr2, arr2.length);
        }
        return arr1[0];
    }
}