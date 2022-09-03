class Solution {
    int[] digits = {0,1,2,3,4,5,6,7,8,9};
    ArrayList<Integer> result = new ArrayList<>();
    int N;
    int K;
    public int[] numsSameConsecDiff(int n, int k) {
        N = n;
        K = k;
        for(int i = 1; i<=9; i++){
            find(i, 0);
        }
        int[] out = new int[result.size()];
        int i = 0;
        for(int r : result){
            out[i] = r;
            i += 1;
        }
        return out;
    }
    public void find(int start, int val){
        val = val*10 + start;
        if(String.valueOf(val).length() == N){
            if(!result.contains(val)) result.add(val);
            return;
        }
        
        if(String.valueOf(val).length() > N){
            return;
        }
        
        
        if(start + K <= 9){
            find(start+K, val);
        }
        if(0<= start-K){
            find(start-K , val);
        }
    }
}