class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        int n = s.length();
        if(t.length() != n) return false;
        for(int i = 0; i< n;i++){
            arr[s.charAt(i)-'a'] += 1;
            arr[t.charAt(i)-'a'] -= 1;
        }
        // System.out.println(Arrays.toString(arr));
        for(int i = 0; i< 26;i++){
            if(arr[i] != 0) return false;
        }
        return true;
    }
}