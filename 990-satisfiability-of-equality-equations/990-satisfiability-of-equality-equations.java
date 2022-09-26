class Solution {
    int[] alpha;
    HashMap<Integer, HashSet<Integer>> ban;
    public boolean equationsPossible(String[] equations) {
        alpha = new int[26];
        ban = new HashMap<>();
        for(int i = 0 ; i < 26; i++){
            alpha[i] = i;
        }
        // System.out.println(Arrays.toString(alpha));
        for(String s : equations){
            // System.out.println(Arrays.toString(alpha));
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
    
    public void banned(int x, int y){
        int px = getParent(x);
        int py = getParent(y);
        HashSet<Integer> temp1 = ban.getOrDefault(px, new HashSet<>());
        temp1.add(py);
        HashSet<Integer> temp2 = ban.getOrDefault(py, new HashSet<>());
        temp2.add(px);
        ban.put(px,temp1);
        ban.put(py,temp2);   
    }
    public boolean isBanned(int x, int y){
        int px = getParent(x);
        int py = getParent(y);
        if(ban.getOrDefault(px, new HashSet<>()).contains(py)) return true;
        if(ban.getOrDefault(py, new HashSet<>()).contains(px)) return true;
        return false;
    }
}