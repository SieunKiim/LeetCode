class Solution {
    int[] dx = new int[] {-1, 0, 1, 0};
    int[] dy = new int[] {0, -1, 0, 1};
    int n;
    int m;
    int[][] dp;

    class Node{
        int i;
        int j;
        int val;
        int step;

        public Node(int i, int j, int val, int step){
            this.i = i;
            this.j = j;
            this.val = val;
            this.step = step;
        }

        public int nextVal(){
            return this.val+ this.step;
        }

        public int nextStep(){
            return (step % 2) + 1;
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        n = moveTime.length;
        m = moveTime[0].length;
        dp = new int[n][m];
        for(int i =0 ;i<n ;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }


        PriorityQueue<Node> que = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);
        dp[0][0] = 0;
        que.add(new Node(0,0,0,1));

        while(!que.isEmpty()){

            Node now = que.poll();
            if(now.i == n-1 && now.j == m-1){
                break;
            }

            // interval = (interval % 2) + 1;
            for(int d= 0; d< 4;d++){
                int ni = now.i + dx[d];
                int nj = now.j + dy[d];
                if(canGo(ni,nj) && now.nextVal() < dp[ni][nj]){
                    dp[ni][nj] = Math.max(now.nextVal(), moveTime[ni][nj] + now.step);
                    que.add(new Node(ni, nj, dp[ni][nj], now.nextStep()));
                }
            }
        }
        return dp[n-1][m-1];
    }

    private boolean canGo(int i, int j){
        return 0<= i && i < n && 0 <= j && j < m;
    }
}