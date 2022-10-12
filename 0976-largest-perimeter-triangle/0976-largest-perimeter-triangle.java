class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = n-1; i>= 2; i--){
            int[] temp= Arrays.copyOfRange(nums, i-2, i+1);
            int max = Arrays.stream(temp).max().getAsInt();
            int total = Arrays.stream(temp).sum();
            if(max< total-max)
                return total;
        }
        return 0;
    }
}