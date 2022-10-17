class Solution {
    public boolean checkIfPangram(String s) {
        int n = s.length();
        int[] alpha = new int[26];
        
        for (int i = 0; i< n ;i++){
            char now = s.charAt(i);
            if('a'<= now && now <= 'z'){
                alpha[now-'a'] = 1;
            }
        }
        if(Arrays.stream(alpha).sum() == 26) return true;
        else return false;
    }
}