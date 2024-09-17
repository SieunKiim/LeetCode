import java.util.Map.Entry;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap();
        Arrays.stream(s1.split(" ")).forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));
        Arrays.stream(s2.split(" ")).forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));
        ArrayList<String> output = new ArrayList();
        for(Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) {
                output.add(entry.getKey());
            }
        }
        return output.toArray(new String[0]);
    }
}