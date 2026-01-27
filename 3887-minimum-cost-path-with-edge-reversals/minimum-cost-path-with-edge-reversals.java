class Solution {
    public int minCost(int n, int[][] edges) {
        // int[][] map = new int[n][n];
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int[] output = new int[n];
        
        Arrays.fill(output, Integer.MAX_VALUE);

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            HashMap<Integer, Integer> row1 = map.getOrDefault(u, new HashMap<>());
            Integer weight1 = row1.getOrDefault(v, Integer.MAX_VALUE);
            row1.put(v, Math.min(weight1, w));
            map.put(u, row1);

            HashMap<Integer, Integer> row2 = map.getOrDefault(v, new HashMap<>());
            Integer weight2 = row2.getOrDefault(u, Integer.MAX_VALUE);
            row2.put(u, Math.min(weight2, w * 2));
            map.put(v, row2);

            // map[u][v] = Math.min(w, map[u][v]);
            // map[v][u] = Math.min(w * 2,map[v][u]);
        }
        // System.out.println(map);

        Deque<Integer> que = new ArrayDeque<>();
        que.add(0);
        output[0] = 0;
        while(!que.isEmpty()){
            int now = que.poll();
            HashMap<Integer, Integer> row = map.getOrDefault(now, null);
            if(row == null) continue;
            for(int next : row.keySet()){
                int tempWeight = row.get(next);
                if(tempWeight + output[now] < output[next]){
                    output[next] = tempWeight + output[now];
                    que.add(next);
                }
            }
        }
        return output[n-1] == Integer.MAX_VALUE ? -1 : output[n-1] ;
    }
}