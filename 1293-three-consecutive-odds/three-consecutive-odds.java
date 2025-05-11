class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        // boolean[] chart = new boolean[10001];
        // Arrays.fill(chart, true);

        // chart[0] = false;
        // chart[1] = false;

        // for(int i = 2; i*i< 1001; i++){
        //     if(chart[i]){
        //         for(int j = i*i ; j <1001;  j += i){
        //             chart[j] = false;
        //         }
        //     }
        // }
        if(arr.length < 3)
            return false;
        
        for(int i = 1; i<arr.length-1;i++){
            if((arr[i-1] %2 == 1) && (arr[i] %2 == 1) && (arr[i+1] %2 == 1))return true;
            // if(chart[arr[i-1]] && chart[arr[i]] && chart[arr[i+1]]) return true;
        }

        return false;
    }
}