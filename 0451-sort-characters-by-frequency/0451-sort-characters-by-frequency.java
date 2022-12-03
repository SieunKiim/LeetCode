class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ;i<s.length(); i++){
            char now = s.charAt(i);
            map.put(now, map.getOrDefault(now, 0)+1);
        }
        List<Map.Entry<Character,Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1,o2) -> o2.getValue()- o1.getValue());
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<Character,Integer> entry : entryList){
            char now = entry.getKey();
            int count = entry.getValue();
            for(int i = 0; i< count;i++){
                sb.append(now);
            }
        }
        return sb.toString();
    }
}