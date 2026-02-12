class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int result=0;
        for(int i=0; i<n; i++){
            int[] frq = new int[26];
            int maxfrq =0;
            int dist =0;
            for(int j=i; j<n; j++){
                char ch = s.charAt(j);
                int idx= ch-'a';
                if(frq[idx]==0){
                    dist++;
                }
                frq[idx]+=1;
                maxfrq = Math.max(maxfrq,frq[idx]);
                if(maxfrq*dist==j-i+1){
                    result = Math.max(result, j-i+1);
                }
            }
        }
        return result;
    }
}