class Solution {

    boolean[] visited;
    int[][] map;  

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        map = isConnected;
        int count = 0;
        visited = new boolean[n];
        for(int i =0 ;i <n ;i++){
            if(!visited[i]){
                count += 1;
                dfs(i);
            }
        }
        return count;
    }

    public void dfs(int now){
        if(visited[now]) return;
        visited[now] = true;

        int[] nexts = map[now];

        for(int i = 0 ; i< nexts.length;i++){
            if(nexts[i] == 1 && !visited[i]) dfs(i);
        }
    }
}