class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int gap = arr[1] - arr[0];
        for(int i = 1; i<n;i++){
            if(arr[i] - arr[i-1] != gap) return false;
        }
        return true;
    }
}