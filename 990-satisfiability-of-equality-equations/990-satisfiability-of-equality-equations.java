class Solution {
    int[] alpha;
    public boolean equationsPossible(String[] equations) {
        alpha = new int[26];
        for(int i = 0 ; i < 26; i++){
            alpha[i] = i;
        }
        for(String s : equations){
            boolean result = false;
            int index1 = s.charAt(0)-97;
            int index2 = s.charAt(3)-97;
            System.out.println(index1 + " "+ index2);
            if(s.charAt(1) == '='){
                union(index1, index2);
            }
        }
        for (String s : equations){
            int index1 = s.charAt(0)-97;
            int index2 = s.charAt(3)-97;
            if(s.charAt(1) == '!'){
                int px = getParent(index1);
                int py = getParent(index2);
                if(py == px) return false;
            }
        }
        return true;
    }
    public int getParent(int x){
        if(alpha[x] == x) return x;
        return alpha[x] = getParent(alpha[x]);
    }
    
    public void union(int x, int y){
        int px = getParent(x);
        int py = getParent(y);
        if(px < py) alpha[py] = px;
        else alpha[px] =py;
    }
}