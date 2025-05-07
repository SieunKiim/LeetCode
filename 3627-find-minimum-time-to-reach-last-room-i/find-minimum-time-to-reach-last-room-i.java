class Solution {
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, -1, 0, 1};
    int n;
    int m;

    class Node{
        int i;
        int j;
        int val;

        public Node(int i, int j, int val){
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    int[][] dp;
    public int minTimeToReach(int[][] moveTime) {
        n = moveTime.length;
        m = moveTime[0].length;
        dp = new int[n][m];

        for(int i = 0 ;i <n ;i++){
            for(int j = 0; j< m ;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Node> que = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        que.add(new Node(0,0,0));
        dp[0][0] = 0;
        while(!que.isEmpty()){
            Node now = que.poll();
            if(now.i == n-1 && now.j  == m-1){
                break;
            }
            for(int d =0 ;d<4;d++){
                int ni = now.i + dx[d];
                int nj = now.j + dy[d];
                if(canGo(ni,nj) && now.val+1 < dp[ni][nj]){
                    dp[ni][nj] = Math.max(moveTime[ni][nj]+1, now.val + 1);
                    que.add(new Node(ni,nj, dp[ni][nj]));
                }
            }
        }
        return dp[n-1][m-1];
    }

    private boolean canGo(int i, int j){
        return 0<= i && i < n && 0 <= j && j < m;
    }
}