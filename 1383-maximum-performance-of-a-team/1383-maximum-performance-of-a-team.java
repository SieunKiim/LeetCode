

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] ess = new int[n][2];
        for (int i = 0; i < n; ++i)
            ess[i] = new int[] {efficiency[i], speed[i]};
        Arrays.sort(ess, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = 0, sumS = 0;
        for (int[] es : ess) {
            pq.add(es[1]);
            sumS = (sumS + es[1]);
            if (pq.size() > k) sumS -= pq.poll();
            res = Math.max(res, (sumS * es[0]));
        }
        return (int) (res % (long)(1e9 + 7));
//         ArrayList<int[]> preset = new ArrayList<>();
//         for(int i = 0 ; i< n ; i++){
//             preset.add(new int[] {speed[i], efficiency[i]});
//         }
//         preset.sort(((o1, o2) -> o2[1]- o1[1]));
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
        
//         int sum = 0;
//         int answer = 0;
//         for(int[] p : preset){
//             sum += p[0];
//             pq.add(p[0]);
//             while(pq.size() > k){
//                 sum -= pq.poll();
//             }
//             answer = Math.max(answer,  sum * p[1]);
//         }
        // return (int)(answer % (Math.pow(10,9) + 7));
    }
}