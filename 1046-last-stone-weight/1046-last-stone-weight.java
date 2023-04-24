class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2 - o1);
        for(int stone : stones){
            pq.add(stone);
        }
        
        while(pq.size() >1){
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a-b);
        }
        return pq.poll();
    }
}