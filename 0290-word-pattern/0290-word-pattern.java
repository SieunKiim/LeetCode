class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashSet<String> wordPool = new HashSet<>();
        int n = words.length;
        if(n != pattern.length()) return false;
        HashMap<Character, String> dict = new HashMap<>();
        for(int i = 0 ; i< n; i++){
            String now = words[i];
            char pat = pattern.charAt(i);
            String target = dict.getOrDefault(pat, "");
            if(target.equals("")){
                dict.put(pat, now);
                if(wordPool.contains(now))
                    return false;
                wordPool.add(now);
            }
            else if(!target.equals(now)) return false;
        }
        return true;
    }
}