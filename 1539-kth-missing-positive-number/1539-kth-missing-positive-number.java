class Solution {
    public int findKthPositive(int[] arr, int k) {
        int gap = arr[0]-1;
        int index = 0;
        if(gap >= k) return k;
        while(index < arr.length-1 && gap + arr[index+1]-arr[index]-1 <k){
            gap += arr[index+1]-arr[index]-1;
            index += 1;
        }
        return arr[index] + k-gap;
    }
}