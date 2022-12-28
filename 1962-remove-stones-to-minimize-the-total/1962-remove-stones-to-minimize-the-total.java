class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2- o1);
        int total = 0;
        for(int p : piles){
            total += p;
            pq.add(p);
        }
        for(int i =0 ; i<k ;i++){
            int temp = pq.poll();
            int half = temp/2;
            total -= half;
            pq.add(temp-half);
        }
        return total;
    }
}