class Solution {
    
    int n;
    boolean[] visited;
    List<List<Integer>> paths;
    int[][] nodes;
    
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        paths = new ArrayList<>();
        visited = new boolean[n];
        nodes = graph;
        List<Integer> path = new ArrayList<>();
        
        dfs(0, path);
        return paths;
    }
    
    public void dfs(int now, List<Integer> path){
        visited[now] = true;
        path.add(now);
        if(now == n-1){
            paths.add(new ArrayList<>(path));
            visited[now] = false;
            path.remove(path.size()-1);
            return;
        }
        
        int[] nexts = nodes[now];
        for(int next : nexts){
            if(!visited[next]){
                dfs(next, path);
            }
        }
    
        visited[now] = false;
        path.remove(path.size()-1);
    }
}