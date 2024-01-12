class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> arr= new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int left =0;
        int right = 0;
        int n = s.length();
        for(int i =0 ; i< n/2;i++){
            int j = i+n/2;
            if(arr.contains(s.charAt(i)))
                left += 1;
            
            if(arr.contains(s.charAt(j)))
                right += 1;
        }

        
        return left == right;
    }
}