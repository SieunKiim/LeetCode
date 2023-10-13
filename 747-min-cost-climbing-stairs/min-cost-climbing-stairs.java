class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(0);
        dp.add(cost[0]);
        for(int i = 1; i<n;i++){
            int temp = Math.min(dp.get(i-1),dp.get(i)) + cost[i];
            dp.add(temp);
        }
        int lastIndex = dp.size()-1;
        return Math.min(dp.get(lastIndex),dp.get(lastIndex-1));
    }
}