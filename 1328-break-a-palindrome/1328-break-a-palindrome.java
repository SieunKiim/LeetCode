class Solution {
    public String breakPalindrome(String s) {
        if(s.length() == 1) return "";
        StringBuilder sb = new StringBuilder(s);
        
        int index = 0;
        while(index< s.length()/2){
            if(s.charAt(index)!= 'a'){
                sb.setCharAt(index,'a');
                return sb.toString();
            }
            index +=1;
        }
        
       
        sb.setCharAt(s.length()-1,'b');
        return sb.toString();
        
    }
}