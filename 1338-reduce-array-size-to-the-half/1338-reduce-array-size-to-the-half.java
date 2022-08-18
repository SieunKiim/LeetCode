class Solution {
    public int minSetSize(int[] arr) {
        int total = arr.length;
        
        HashMap<Integer, Integer> dict = new HashMap<>();

        for (int i : arr){
            if (dict.get(i) != null){
                dict.put(i, dict.get(i)+1);
            } else {
                dict.put(i, 1);
            }
        }
        
        List<Map.Entry<Integer, Integer>> SortedMap = new LinkedList<>(dict.entrySet());
        SortedMap.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        int count = 0;
        int rest = 0;
        for (Map.Entry<Integer, Integer> i : SortedMap){
            rest += i.getValue();
            count += 1;
            if (rest >= total/2){
                break;
            }
        }
        
        return count;
    }
}