class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        int max = 0;
        
        for(int num : arr){
            int val = dict.getOrDefault(num, 0) +1;
            max = Math.max(max, val);
            dict.put(num, val);
        }
        
        boolean[] check = new boolean[max+1];
        for(Map.Entry<Integer, Integer> entry : dict.entrySet()){
            int index = entry.getValue();
            if(check[index]){
                return false;
            }
            check[index] =  true;
        }
        return true;
    }
}