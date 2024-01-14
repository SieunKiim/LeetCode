class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        if(n1 != n2) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i =0 ;i < n1;i++){
            arr1[word1.charAt(i)-'a'] += 1;
            arr2[word2.charAt(i)-'a'] += 1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ;i<26;i++){
            if((arr2[i] == 0 && arr1[i] != 0) || (arr1[i] == 0 && arr2[i] != 0)){
                return false;
            }
            int temp = map.getOrDefault(arr1[i], 0);
            map.put(arr1[i], temp + 1);
        }

        for(int i = 0 ;i<26;i++){
            int temp = map.getOrDefault(arr2[i], 0);
            if(temp == 0) return false;

            if(temp-1 ==0) {
                map.remove(arr2[i]);
                continue;
            }
            map.put(arr2[i], temp-1);
        }
        return map.size() == 0;
    }
}