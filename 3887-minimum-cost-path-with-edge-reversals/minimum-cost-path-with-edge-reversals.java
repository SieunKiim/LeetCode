class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w * 2});
        }
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0}); // {노드, 거리}
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            if (cost > dist[node]) continue;
            if (node == n - 1) return cost;
            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int nextCost = cost + next[1];
                
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new int[]{nextNode, nextCost});
                }
            }
        }
        
        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }
}