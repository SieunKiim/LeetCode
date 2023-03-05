class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Deque<Integer> que = new ArrayDeque<>();
        que.add(0);
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0;i<n; i++){
            int now = arr[i];
            ArrayList<Integer> temp = map.getOrDefault(now, new ArrayList<>());
            temp.add(i);
            map.put(now, temp);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while(!que.isEmpty()){
            int index = que.poll();
            if(index == n-1) return dp[n-1];
            
            int key = arr[index];
            int nextVal = dp[index]+1;
            if(map.containsKey(key)) {
            ArrayList<Integer> nexts = (ArrayList<Integer>)map.get(key).clone();
            map.remove(key);
                for(int i : nexts){
                if(!visited[i]){
                    que.add(i);
                    dp[i] = nextVal;
                    visited[i] = true;
                }
            }}
            if(index -1 >= 0 && !visited[index-1]){
                que.add(index-1);
                dp[index-1] = nextVal;
                visited[index-1] = true;
            }
            if(index+ 1 < n && !visited[index+1]){
                que.add(index +1);
                dp[index+1] = nextVal;
                visited[index+1] = true;
            }
            
        }
        return -1;
    }
}