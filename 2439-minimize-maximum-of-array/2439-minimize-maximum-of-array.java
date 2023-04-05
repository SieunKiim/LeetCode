class Solution {
    public int minimizeArrayValue(int[] nums) {
        // 그리디 풀이 O(n)
//         int n = nums.length;
//         long sum = 0;
//         int output = 0;
//         for(int i = 0; i< n ; i++){
//             sum += nums[i];
//             int mean = (int) Math.ceil((double)sum/(i+1));
//             if(mean <= nums[i]) output = Math.max(output, mean);
//         }
        
//         return output;
        

        // 이분탐색 풀이
        int left = 0, right = Arrays.stream(nums).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
    public boolean check(int[] nums, int k) {
        long have = 0;
        for (int n : nums) {
            if (n <= k) {
                have += k - n;
            } else {
                if (have < n - k)
                    return false;
                else
                    have -= (n - k);
            }
        }
        return true;
    }
}