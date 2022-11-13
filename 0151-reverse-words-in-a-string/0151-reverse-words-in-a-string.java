import java.util.*;
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            
            sb.insert(0, st.nextToken()+ " ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
//         StringBuilder result = new StringBuilder();
        
//         StringBuilder temp = new StringBuilder();
        
//         for(int i = 0; i<s.length(); i++){
//             char now = s.charAt(i);
//             if(now == ' '){
//                 if(temp.length() != 0){
//                     result.append(temp);
//                     temp = new StringBuilder();
//                 }
//             } else {
//                 temp.append(now);
//             }
//         }
//         return result.toString();
    }
}