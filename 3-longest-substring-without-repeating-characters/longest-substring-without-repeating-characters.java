class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        int output = 0;
        while(right < n){
            char rightChar = s.charAt(right);
            // System.out.println("left : "  + left + " right : " + right);
            while(set.contains(rightChar) && left < right){
                // System.out.println("inner | left : "  + left + " right : " + right);
                char leftChar = s.charAt(left);
                set.remove(leftChar);
                left+= 1;
            }
            set.add(rightChar);
            output = Math.max(output, right-left + 1);
            // System.out.println("output : " + output);
            right += 1;
        }
        return output;
    }
}