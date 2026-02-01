class Solution {
    public int minimumCost(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = nums[0];
        for(int i = 1; i<nums.length;i++){
            pq.add(nums[i]);
        }
        return sum + pq.poll() + pq.poll();
    }
}