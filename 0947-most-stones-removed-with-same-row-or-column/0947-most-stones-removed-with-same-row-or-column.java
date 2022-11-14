class Solution {
    public int removeStones(int[][] stones) {
        boolean[] visited = new boolean[stones.length];
        HashMap<Integer, List<Integer>> row = new HashMap<>();
        HashMap<Integer, List<Integer>> col = new HashMap<>();
        for (int i = 0; i < stones.length; i++){
            row.computeIfAbsent(stones[i][0], o -> new ArrayList<>()).add(i);
            col.computeIfAbsent(stones[i][1], o -> new ArrayList<>()).add(i); 
        }

        int numOfIsland = 0;
        for (int i = 0; i < stones.length; i++)
            if (!visited[i]){
                removeIsland(visited, stones, i, row, col);
                numOfIsland++;
            }

        return stones.length - numOfIsland;
    }

    private void removeIsland(boolean[] visited, int[][] stones, int idx,
            Map<Integer, List<Integer>> row, Map<Integer, List<Integer>> col){
        if (visited[idx]) return;

        visited[idx] = true;
        int r = stones[idx][0];
        int c = stones[idx][1];
        for (int index : row.get(r)) 
            removeIsland(visited, stones, index, row, col); 
        for (int index : col.get(c))
            removeIsland(visited, stones, index, row, col);
    }
}