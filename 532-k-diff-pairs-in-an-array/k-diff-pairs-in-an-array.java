class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n <= 1) return 0;
        int left = 0;
        int right = 1;
        int count = 0;
        Set<String> set = new HashSet<>();
        while(left < n&& right < n){
            if(left == right){
                right += 1;
                continue;
            }

            if(nums[right]-nums[left] < k){
                right += 1;
            } else if (nums[right]-nums[left] > k) {
                left += 1;
            } else {
                // count += 1;
                set.add(nums[left] + " " + nums[right]);
                left += 1;
            }
        }

        return set.size();
    }
}