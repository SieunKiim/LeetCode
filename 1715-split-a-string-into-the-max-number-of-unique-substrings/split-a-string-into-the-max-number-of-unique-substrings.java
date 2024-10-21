class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return dfs(s, 0, set);

    }

    public int dfs(String s, int start, Set<String> set){
        if(start == s.length()){
            return 0;
        }
        int maxCount = 0;
        for(int end = start+1; end<=s.length(); end++){
            String sub = s.substring(start, end);
            if(!set.contains(sub)){
                set.add(sub);
                maxCount = Math.max(maxCount, 1+dfs(s, end, set));
                set.remove(sub);
            }
        }
        return maxCount;
    }
}