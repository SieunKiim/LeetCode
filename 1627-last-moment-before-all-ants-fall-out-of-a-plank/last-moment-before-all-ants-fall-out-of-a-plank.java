class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int output = 0;
        Arrays.sort(left);
        Arrays.sort(right);
        if(left.length != 0){
            output = left[left.length-1];
        }
        if(right.length!= 0){
            output = Math.max(output, n-right[0]);
        }
        return output;
    }
}