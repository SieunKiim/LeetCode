class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int answer = 0;
        int target = nums[n/2];
        for (int num : nums) {
            answer += Math.abs(num - target);
        }
        return answer;
    }
}
