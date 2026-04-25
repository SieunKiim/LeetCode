class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        for(int i =0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1])continue;

            int numI = nums[i];
            int j = i+1;
            int k = n-1;

            while(j < k){
                if(nums[i] + nums[j] + nums[k] == 0) {
                    output.add(List.of(nums[i],nums[j], nums[k]));
                    j+=1;
                    k-=1;
                    while(j<k && nums[j]==nums[j-1]) j+=1;
                    continue;
                }
                if(-nums[i] <nums[j] + nums[k]){
                    k-=1;
                }else{
                    j+=1;
                }
            }
        }
        return output;
    }
}