class Solution {
    int[] arr;
    public int minNumberOperations(int[] target) {
        arr= target;
        int last = 0;
        int n = target.length;
        int sum = 0;
        int low = 0;
        int top = 0;
        int lastGradiant= 1;
        for (int i =0;i<n;i++){
            int fg = forwardGradiant(i);
            int now = arr[i];
            if(lastGradiant >0 && fg < 0){ // 꼭대기
                top = now;
                sum += top-low;
                lastGradiant = fg;
            } else if (lastGradiant <0 && fg > 0) { // 저점
                low = now;
                top = -1;
                lastGradiant = fg;
            } else {
                if(lastGradiant > 0){
                    top = now;
                } else {
                    low = now;
                }
            }
            
        }
        
        return sum;
    }

    // private int nextGradiant(int i){
    //     if(i == 0) return 1;

    //     return arr[i] - arr[i-1];
    // }

    private int forwardGradiant(int i){
        if(i == arr.length-1) return -1;

        return arr[i+1]-arr[i];
    }
}