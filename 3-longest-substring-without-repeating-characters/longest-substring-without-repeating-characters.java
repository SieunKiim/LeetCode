class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        if(n < 1) return 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        set.add(s.charAt(0));
        int maxLen = 1;
        while(right < n){
            char r = s.charAt(right);
            while(set.contains(r) && left<right){
                set.remove(s.charAt(left));
                left += 1;
            }
            right += 1;
            set.add(r);
            maxLen = Math.max(maxLen, right-left);
        }
        return maxLen;
    }
}