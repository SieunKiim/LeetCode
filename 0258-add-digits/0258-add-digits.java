class Solution {
    public int addDigits(int num) {
        if(num < 10) return num;
        String s = String.valueOf(num);
        
        int next = 0;
        for(int i = 0; i < s.length(); i++){
            next += (s.charAt(i)-'0');
        }
        return addDigits(next);
    }
}