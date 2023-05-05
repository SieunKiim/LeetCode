class Solution {
    HashSet<Character> vowels = new HashSet<>();
    public int maxVowels(String s, int k) {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int count = 0;
        int res = 0;
        for(int i= 0; i<s.length();i++){
            char now = s.charAt(i);
            if(i < k ){
                if(vowels.contains(now))
                {count += 1;
                res = Math.max(res, count);}
                continue;
            }
            if(vowels.contains(now)){
                count += 1;
            }
            if(vowels.contains(s.charAt(i-k))){
                count -=1;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}