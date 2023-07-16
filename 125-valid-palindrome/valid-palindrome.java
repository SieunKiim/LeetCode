class Solution {
    public boolean isPalindrome(String s) {
        String a = s.toLowerCase();
        a = a.replaceAll("[^a-z0-9]","");
        System.out.println(a);
        for(int i = 0; i<a.length()/2;i++){
            if(a.charAt(i) != a.charAt(a.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}