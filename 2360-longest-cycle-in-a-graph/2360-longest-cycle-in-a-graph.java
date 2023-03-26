class Solution {
    int answer = -1;

    public void dfs(int node, int[] edges, Map<Integer, Integer> dist, boolean[] visit) {
        visit[node] = true;
        int neighbor = edges[node];

        if (neighbor != -1 && !visit[neighbor]) {
            dist.put(neighbor, dist.get(node) + 1);
            dfs(neighbor, edges, dist, visit);
        } else if (neighbor != -1 && dist.containsKey(neighbor)) {
            answer = Math.max(answer, dist.get(node) - dist.get(neighbor) + 1);
        }
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(i, 1);
                dfs(i, edges, dist, visit);
            }
        }
        return answer;
    }
//     int[] cycleCount;
//     int N;
//     HashMap<Integer, Integer> map;
//     int output;

//     public int longestCycle(int[] edges) {
//         map = new HashMap<>();
//         N = edges.length;
//         cycleCount = new int[N];
//         output = -1;
//         Arrays.fill(cycleCount, -1);

//         for (int i = 0; i < N; i++) {
//             if (edges[i] != -1) {
//                 map.put(i, edges[i]);
//             }
//         }

//         for (int i = 0; i < N; i++) {
//             dfs(i, new int[N], 1);
//         }
//         return output;
//     }

//     public int dfs(int now, int[] visited, int count) {
//         if(!map.containsKey(now)) return -1;
//         if (cycleCount[now] != -1) {
//             return cycleCount[now];
//         }

//         if (visited[now] != 0) {
//             output = Math.max(output, count - visited[now]);
//             cycleCount[now] = count - visited[now];
//             return cycleCount[now];
//         }
//         visited[now] = count;
//         return cycleCount[now] = dfs(map.get(now), visited, count += 1);
//     }
}
