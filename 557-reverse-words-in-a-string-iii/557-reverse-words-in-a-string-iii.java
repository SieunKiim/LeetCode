class Solution {
    public String reverseWords(String s) {
        String answer = "";
        String[] temp = s.split(" ");
        answer += reverse(temp[0]);
        for(int i = 1; i<temp.length; i++){
            answer +=  ' ';
            answer += reverse(temp[i]);
            
        }
        return answer;
    }
    
    public String reverse(String s){
        String output = "";
        for(int i = s.length()-1; i >= 0 ; i--){
            output += s.charAt(i);
        }
        return output;
    }
}