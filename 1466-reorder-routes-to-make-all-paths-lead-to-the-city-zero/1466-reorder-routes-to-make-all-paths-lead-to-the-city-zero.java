class Edge {
    int vertex, count;
    public Edge(int vertex, int count) {
        this.vertex = vertex;
        this.count = count;
    }
}

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < connections.length; i++) {
            graph.get(connections[i][0]).add(new Edge(connections[i][1], 1));
            
            graph.get(connections[i][1]).add(new Edge(connections[i][0], 0));
        }
        
        return dfs(graph, 0, new boolean[n]);
    }
    
    public int dfs(List<List<Edge>> graph, int source, boolean[] isVisited) {
        int cost = 0;
        isVisited[source] = true;
        
        for(Edge neighbour : graph.get(source)) {
            if(!isVisited[neighbour.vertex]) {
                cost += neighbour.count + dfs(graph, neighbour.vertex, isVisited);
            }
        }
        return cost;
    }
}
