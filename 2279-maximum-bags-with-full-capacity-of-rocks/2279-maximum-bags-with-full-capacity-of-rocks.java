class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
        for (int i = 0; i < capacity.length; i++) pq.add(new int[] { rocks[i], capacity[i] });
        int c = 0;
        while (!pq.isEmpty() && additionalRocks > 0) {
            int curr[] = pq.remove();
            int req = curr[1] - curr[0];
            if (additionalRocks < req) break;
            additionalRocks -= req;
            c++;
        }
        return c;
    }
}