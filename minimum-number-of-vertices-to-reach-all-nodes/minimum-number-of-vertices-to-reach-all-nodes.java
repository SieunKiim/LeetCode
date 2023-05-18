class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] visited = new boolean[n];
        List<Integer> output = new ArrayList<>();
        for(List<Integer> edge : edges) {
            visited[edge.get(1)] = true;
        }

        for(int i =0 ;i< n;i++){
            if(!visited[i]) output.add(i);
        }
        return output;
    }
}