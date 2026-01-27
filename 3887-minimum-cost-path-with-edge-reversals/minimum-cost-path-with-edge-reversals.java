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

        }

        PriorityQueue<int[]> que = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        que.add(new int[]{0,0});
        output[0] = 0;
        while(!que.isEmpty()){
            int[] now = que.poll();
            if (now[0] == n-1) return now[1];
            HashMap<Integer, Integer> row = map.getOrDefault(now[0], null);
            if(row == null) continue;
            for(int next : row.keySet()){
                int tempWeight = row.get(next);
                if(tempWeight + now[1] < output[next]){
                    output[next] = tempWeight + output[now[0]];
                    que.add(new int[]{next, output[next]});
                }
            }
        }
        return output[n-1] == Integer.MAX_VALUE ? -1 : output[n-1] ;
    }
}