import java.util.*;
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            
            sb.insert(0, st.nextToken() + " ");
        }
        
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}