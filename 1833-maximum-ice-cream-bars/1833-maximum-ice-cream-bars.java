class Solution {
    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int cost: costs){
            pq.add(cost);
        }
        
        int count = 0;
        while(!pq.isEmpty() && pq.peek() <= coins){
            coins -= pq.poll();
            count += 1;
        }
        
        return count;
    }
}