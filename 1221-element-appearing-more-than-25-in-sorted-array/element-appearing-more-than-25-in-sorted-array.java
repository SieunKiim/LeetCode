class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int huddle = n/4 + 1;
        
        int count = 1;
        int last = arr[0];
        for(int i= 1; i<n;i++){
            int now = arr[i];
            if(now == last){
                count += 1;
                if(count >= huddle){
                    return now;
                }
            } else {
                count = 1;
                last = now;
            }
        }
        return arr[0];
    }
}