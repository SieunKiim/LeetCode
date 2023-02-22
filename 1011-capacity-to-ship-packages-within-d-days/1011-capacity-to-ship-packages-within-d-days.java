class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        int n = weights.length;
        for(int w : weights){
            left = Math.max(left, w);
            right += w;
        }
        while(left < right){
            int mid = (left + right)/2;
            int count = 1;
            int sum = 0;
            for(int i =0 ; i< n; i++){
                if(sum + weights[i] > mid){
                    count +=1;
                    sum = weights[i];
                } else {
                    sum += weights[i];
                }
            }
            if(count > days){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        return left;
    }
}