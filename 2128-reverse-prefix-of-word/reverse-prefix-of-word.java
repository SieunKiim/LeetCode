class Solution {
    public String reversePrefix(String word, char ch) {
        char[] words = word.toCharArray();
        int n = word.length();
        int index= 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<n ; i++){
            char now = words[i];
            sb.append(now);
            if(now == ch) {
                break;
            }
            index += 1;
        }
        if(index >= n) return sb.toString();
        sb.reverse();
        for(int i = index+1; i<n;i++){
            sb.append(words[i]);
        }
        return sb.toString();
    }
}