
class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap();
        map.put('a', 1);
        map.put('e', 2);
        map.put('i', 4);
        map.put('o', 8);
        map.put('u', 16);

        char[] arr = s.toCharArray();
        int indicator = 0;
        int[] res = new int[arr.length];
        int count = 0;
        int output = 0;
        int[] checker = new int[32];
        Arrays.fill(checker, -1);
        for(int i = 0; i<arr.length; i++){
            indicator ^= map.getOrDefault(arr[i], 0);
            
            if(checker[indicator] == -1 && indicator != 0){
                checker[indicator] = i;
            }
            output = Math.max(output, i-checker[indicator]);

        }
        // System.out.println(Arrays.toString(checker));
        return output;
    }
}