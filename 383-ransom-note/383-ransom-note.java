
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i< magazine.length(); i++){
            dict.put(magazine.charAt(i), dict.getOrDefault(magazine.charAt(i),0)+1);
        }
        
        for (int i = 0; i < ransomNote.length(); i++){
            char temp = ransomNote.charAt(i);
            int num = dict.getOrDefault(temp, 0);
            if (num == 0) return false;
            else{
                dict.put(temp,num-1);
            }
        }
        
        return true;
    }
}