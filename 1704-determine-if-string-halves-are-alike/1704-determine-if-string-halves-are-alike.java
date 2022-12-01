class Solution {
    public boolean halvesAreAlike(String s) {
        HashSet<Character> vouls = new HashSet<>();
        vouls.add('a');
        vouls.add('e');
        vouls.add('i');
        vouls.add('o');
        vouls.add('u');
        vouls.add('A');
        vouls.add('E');
        vouls.add('U');
        vouls.add('I');
        vouls.add('O');
        int n = s.length();
        int l=0;
        int r=0;
        for(int i =0;i<n/2;i++){
            if(vouls.contains(s.charAt(i))) l+=1;
            if(vouls.contains(s.charAt(i+n/2)))
                r+=1;
        }
        return l== r;
    }
}