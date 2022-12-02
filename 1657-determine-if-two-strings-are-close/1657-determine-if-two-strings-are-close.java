class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        
        HashMap<Character, Integer> word1Dict = new HashMap<>();
        HashMap<Character, Integer> word2Dict = new HashMap<>();
        
        for(int i = 0 ;i< word1.length(); i++){
            char oneChar = word1.charAt(i);
            char twoChar = word2.charAt(i);
            word1Dict.put(oneChar, word1Dict.getOrDefault(oneChar, 0)+1);
            word2Dict.put(twoChar, word2Dict.getOrDefault(twoChar, 0)+1);
        }
        // System.out.println(word1Dict.keySet());
        // System.out.println(word2Dict.keySet());
        Set<Character> s1 = word1Dict.keySet();
        Set<Character> s2 = word2Dict.keySet();
        if(!s1.equals(s2)) {
            System.out.println("키 셋 터짐");
            return false;
        }
        
        List<Integer> wv1 = new ArrayList(word1Dict.values());
        List<Integer> wv2 = new ArrayList(word2Dict.values());
        
        Collections.sort(wv1);
        Collections.sort(wv2);
        
        System.out.println(wv1);
        System.out.println(wv2);
        
        for(int i = 0; i<wv1.size(); i++){
            System.out.println("개수 다름"+ i);
            if(!wv1.get(i).equals(wv2.get(i))) {
                System.out.println(wv1.get(i) + " "+ wv2.get(i));
                return false;
            }
        }
        return true;
    }
}