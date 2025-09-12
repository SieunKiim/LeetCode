class Solution {
    public boolean doesAliceWin(String s) {
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e','i','o','u'));
        int count = 0;
        for(int i = 0; i<s.length();i++){
            if(set.contains(s.charAt(i))){
                count += 1;
            }
        }


        if(count %2 == 1){
            return true;
        }

        if(count > 0 && count %2 == 0) return true;
        
        return false;
    }
}