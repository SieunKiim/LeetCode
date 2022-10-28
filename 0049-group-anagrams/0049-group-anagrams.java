class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> dict = new HashMap<>();
        for(String s : strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String target = new String(temp);
            List<String> now = dict.getOrDefault(target, new ArrayList<>());
            now.add(s);
            dict.put(target, now);
        }
        
        return new ArrayList<>(dict.values());
        
        
        // HashMap<HashMap<Character, Integer>, List<String>> dict = new HashMap<>();
        // for(String s : strs){
        //     HashMap<Character, Integer> temp = new HashMap<>();
        //     for(int i = 0; i< s.length(); i++){
        //         temp.put(s.charAt(i), temp.getOrDefault(s.charAt(i), 0) + 1);
        //     }
        //     List<String> now = dict.getOrDefault(temp, new ArrayList<>());
        //     now.add(s);
        //     dict.put(temp, now);
        // }
        // return new ArrayList<>(dict.values());
    }
}