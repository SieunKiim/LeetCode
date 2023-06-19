class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int temp = 0;
        for(int n : gain){
            temp += n;
            max = Math.max(max, temp);
        }
        return max;
    }
}