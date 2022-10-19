class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> dict = new HashMap<>();
        
        for(int i= 0; i<words.length;i++){
            dict.put(words[i], dict.getOrDefault(words[i], 0)+1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(dict.entrySet());
        
        list.sort((o1,o2) -> o1.getValue() == o2.getValue()? o1.getKey().compareTo(o2.getKey()): o2.getValue() - o1.getValue());
        List<String> result = new ArrayList<>();
        System.out.println(dict);
        
        for(int i = 0; i< k ;i++){
            result.add(list.get(i).getKey());
        }
        
        return result;
    }
}