class Solution {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        int nn = goal.length();
        if(n != nn) return false;
        char s1 = '0';
        char g1 = '0';
        char s2 = '0';
        char g2 = '0';
        int count = 0;
        boolean isDuplicated = false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ;i< n;i++){
            char sNow = s.charAt(i);
            char gNow = goal.charAt(i);

            int temp  = map.getOrDefault(sNow, 0)+ 1;
            if (temp == 2) isDuplicated = true;
            map.put(sNow, temp);

            if(sNow != gNow){
                count += 1;
                if(count >2) return false;
                if(count == 1){
                    s1 = sNow;
                    g1 = gNow;
                } else if( count == 2){
                    s2 = sNow;
                    g2 = gNow;
                }
            }
        }
        if(count == 0){
            return isDuplicated;
        }
        return s1==g2 && s2 == g1;
    }
}