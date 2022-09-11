

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        ArrayList<int[]> preset = new ArrayList<>();
        for(int i = 0 ; i< n ; i++){
            preset.add(new int[] {speed[i], efficiency[i]});
        }
        preset.sort(((o1, o2) -> o2[1]- o1[1]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        
        long sum = 0;
        long answer = 0;
        for(int[] p : preset){
            sum = sum + p[0];
            pq.add(p[0]);
            if(pq.size() > k){
                sum -= pq.poll();
            }
            answer = Math.max(answer,  sum * p[1]);
        }
        return (int)(answer %(long)(Math.pow(10,9) + 7));
    }
}