class Solution {
    boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        visited[0] = true;
        que.add(0);
        System.out.println();
        while(!que.isEmpty()){
            List<Integer> nexts = rooms.get(que.poll());
            for(Integer next : nexts){
                if(visited[next]) continue;
                que.add(next);
                visited[next] = true;
            }
        }
        return check();
    }
    
    public boolean check(){
        for(int i = 0; i<visited.length; i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}