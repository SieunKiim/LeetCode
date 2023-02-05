class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] target = new int[26];
        int[] base = new int[26];
        List<Integer> output = new ArrayList<>();
        if(s.length() < p.length()) return output;
        for(int i = 0; i< Math.min(s.length(), p.length());i++){
            target[p.charAt(i)-'a'] +=1;
            base[s.charAt(i)-'a'] +=1;
        }
        if(check(target, base)) output.add(0);
        System.out.println(Arrays.toString(target));
        System.out.println(Arrays.toString(base));
        for(int i = Math.min(s.length(), p.length()); i< Math.max(s.length(), p.length());i++){
            int lastIndex = i-Math.min(s.length(), p.length());
            base[s.charAt(lastIndex) -'a'] -= 1;
            base[s.charAt(i)-'a'] += 1;
            if(check(target, base)) output.add(1+i-Math.min(s.length(), p.length()));
        }
        return output;
    }
    
    public boolean check(int[] target, int[] base){
        for(int i =0 ;i< 26;i++){
            if(target[i] != base[i]) return false;
        }
        return true;
    }
}