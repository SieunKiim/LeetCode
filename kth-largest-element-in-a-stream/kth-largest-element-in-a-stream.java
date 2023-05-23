class KthLargest {

    PriorityQueue<Integer> pq= new PriorityQueue<>();
    int maxSize;

    public KthLargest(int k, int[] nums) {
        maxSize = k;
        for(int num : nums){
            if(pq.size() >= k){
                if(pq.peek() < num){
                    pq.poll();
                    pq.add(num);
                }
            } else {
                pq.add(num);
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() >= maxSize){
            if(pq.peek() < val){
                pq.poll();
                pq.add(val);
            }
        } else {
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */