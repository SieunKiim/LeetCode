class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        char[][] map = new char[n][101];

        for(int i = 0;i < n;i++){
            for(int j = 0;j<101;j++){
                if(strs[i].length() <= j){
                    map[i][j] = 0;
                } else {
                    map[i][j] = strs[i].charAt(j);
                }
            }
            
        }
        // for(int i = 0; i<n ;i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }

        int count = 0;
        boolean[] sorted = new boolean[n-1];
        for(int j = 0; j<101; j++){
            boolean deleteFlag = false;
            for(int i = 0;i <n-1;i++){
                if(!sorted[i] && map[i][j]>map[i+1][j]){
                    // System.out.println(j);
                    count += 1;
                    deleteFlag = true;
                    break;
                }
                
            }
            if(deleteFlag){
                continue;
            }
            for(int i =0;i<n-1;i++){
                if(map[i][j] < map[i+1][j]) {
                    sorted[i] = true;
                }
            }

            boolean temp = true;
            for(boolean a : sorted){
                temp = temp && a;
            }
            if(temp) return count;
        }
        return count;
    }
}