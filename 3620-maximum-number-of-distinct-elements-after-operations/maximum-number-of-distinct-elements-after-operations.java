class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n =nums.length;

        Set<Integer> set = new HashSet<>();
        int possibleMin = nums[0] - k;
        for(int i =0; i< n;i++){
            int now = nums[i];
            possibleMin = Math.max(possibleMin, now-k);
            while(possibleMin < now + k && set.contains(possibleMin)){
                possibleMin += 1;
            }
            set.add(possibleMin);
            
        }
        return set.size();

    }
}