class Solution {
    public int partitionString(String s) {
        HashSet<Character> temp = new HashSet<>();
        int output = 0;
        for(int i = 0; i< s.length();i++){
            char now = s.charAt(i);
            if(temp.contains(now)) {
                output += 1;
                temp.clear();
            } 
            temp.add(now);
        }
        return output + 1;
    }
}