class Solution {
    public String mergeAlternately(String word1, String word2) {
        int a= 0;
        int b= 0;
        int word1Len = word1.length();
        int word2Len = word2.length();
        StringBuilder sb = new StringBuilder();
        while(a < word1Len || b < word2Len){
            if(a < word1Len){
                sb.append(word1.charAt(a));
                a+=1;
            }
            if(b<word2Len){
                sb.append(word2.charAt(b));
                b+=1;
            }
        }
        return sb.toString();
    }
}