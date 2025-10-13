class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> output = new ArrayList<>();
        output.add(words[0]);
        for(int i = 1;i <words.length;i++){
            String lastWord = output.get(output.size()-1);
            if(isAna(lastWord, words[i])){
                continue;
            } else {
                output.add(words[i]);
            }
        }
        return output;
    }

    private boolean isAna(String a, String b){
        int[] arr = new int[26];
        for(char c : a.toCharArray()){
            arr[c-'a'] += 1;
        }

        for(char c : b.toCharArray()){
            arr[c-'a'] -= 1;
        }
        for(int n : arr){
            if(n != 0) return false;
        }
        return true;
    }
}