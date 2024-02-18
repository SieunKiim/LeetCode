class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        int n = heights.length;
        int i;
        for (i = 1; i < n; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff <= 0) {
                continue;
            }
            pq.add(diff);
            if(bricks < diff && !pq.isEmpty()){
                if(ladders == 0){
                    break;
                }
                ladders -= 1;
                bricks += pq.poll();
            }
            bricks -= diff;
        }
        return i-1;
    }
}