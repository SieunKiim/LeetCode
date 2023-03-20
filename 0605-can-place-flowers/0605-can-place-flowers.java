class Solution {
    public boolean canPlaceFlowers(int[] flower, int n) {
        int count = 0;
        int N = flower.length;
        if(N == 1){
            if(flower[0] == 0) count = 1;
            return count >= n;
        }
        for(int i =0 ; i< N; i++){
            if(flower[i] == 0){
                if(i == 0){
                    if(flower[i+1] == 0) {count += 1; flower[i] = 1;}
                } else if (i == N-1){
                    if(flower[N-2] == 0) {count += 1; flower[i] = 1;}
                } else {
                    if(flower[i+1] == 0 && flower[i-1] == 0){ count += 1; flower[i] = 1;}
                }
            }
        }
        return count >= n;
    } 
}