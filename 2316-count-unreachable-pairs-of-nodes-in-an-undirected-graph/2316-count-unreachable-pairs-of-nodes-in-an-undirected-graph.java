class Solution {
    
    boolean[] visited;
    HashMap<Integer,ArrayList<Integer>> map;
    int N;
    public long countPairs(int n, int[][] edges) {
        long result = 0;
        N = n;
        visited = new boolean[n];
        int left = n;
        map = new HashMap<>();
        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            ArrayList<Integer> arrA = map.getOrDefault(a, new ArrayList<>());
            ArrayList<Integer> arrB = map.getOrDefault(b, new ArrayList<>());
            arrA.add(b);
            arrB.add(a);
            map.put(a, arrA);
            map.put(b, arrB);
        }
        for(int i =0 ;i<n; i++){
            if(!visited[i]){
                long groupCount = dfs(i);
                result += (left-groupCount) * groupCount;
                left -= groupCount;
            }
        }
        return result;
    }
    
    public long dfs(int now){
        visited[now] = true;
        
        ArrayList<Integer> nexts = map.get(now);
        if(nexts == null) return 1;
        long output = 1;
        for(int next:nexts){
            if(!visited[next]){
                output += dfs(next);
            }
        }
        return output;
    }
}
