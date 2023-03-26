class Solution {
    public int longestCycle(int[] edges) {
        int[] map = new int[edges.length];
        int result = -1;

        for (int i = 0; i < edges.length; i++)
            result = Math.max(result, helper(i, 1, edges, map));

        return result;
    }

    int helper(int index, int total, int[] edges, int[] map) {
        if (index == -1 || map[index] == -1)
            return -1;

        if (map[index] != 0)
            return total - map[index];

        map[index] = total;
        int result = helper(edges[index], total + 1, edges, map);
        map[index] = -1;

        return result;
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
