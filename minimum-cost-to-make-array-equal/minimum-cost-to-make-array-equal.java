class Solution {
    private long getCost(int[] nums, int[] cost, int base) {
        long result = 0L;
        for (int i = 0; i < nums.length; ++i)
            result += 1L * Math.abs(nums[i] - base) * cost[i];
        return result;
    }
    public long minCost(int[] nums, int[] cost) {
        int left = 1000001, right = 0;
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        long answer = getCost(nums, cost, nums[0]);
        while (left < right) {
            int mid = (right + left) / 2;
            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid + 1);
            answer = Math.min(cost1, cost2);
            
            if (cost1 > cost2) 
                left = mid + 1;
            else
                right = mid;
        }
        return answer;
    }
}