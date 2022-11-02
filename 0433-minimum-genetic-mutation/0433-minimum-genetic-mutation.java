class Solution {
    String[] muts;
    int n; 
    String target;
    public int minMutation(String start, String end, String[] bank) {
        target = end;
        n = bank.length;
        muts = bank;
        boolean[] used = new boolean[n];
        int output = n+1;
        for(int i = 0; i< n; i++){
            if(bank[i].equals(end)){
                output = find(start, 0, used);
                if (output == n+1)
                    output = -1;
                return output;
            }
        }
        return -1;
    }
    
    public int find(String now, int count, boolean[] visited){
        if(now.equals(target)) return 0;
        if(count == n) return -1;
        int result = n+1;
        for(int i= 0; i< n; i++){
            if(!visited[i] && checkValid(now, muts[i])){
                visited[i] = true;
                result = Math.min(find(muts[i], count+1, visited)+1, result);
                visited[i] = false;
            }
        }
        return result;
    }
    
    public boolean checkValid(String a, String b){
        int count = 0;
        for(int i = 0; i< a.length(); i++){
            if(a.charAt(i)!= b.charAt(i)) count += 1;
        }
        if(count == 1) return true; // 0일때도?
        else return false;
    }
}