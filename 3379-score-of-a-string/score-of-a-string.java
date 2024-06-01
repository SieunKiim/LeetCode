class Solution {
    public int scoreOfString(String s) {
        char[] arr = s.toCharArray();
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            sum += Math.abs(arr[i - 1] - arr[i]);
        }
    
        return sum;
    }
}