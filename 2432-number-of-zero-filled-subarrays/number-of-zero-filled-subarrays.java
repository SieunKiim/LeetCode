class Solution {
    public long zeroFilledSubarray(int[] nums) {
        // List<Integer> arr = new ArrayList<>();
        int count = 0;
        long res = 0;
        for(int num : nums){
            if(num == 0){
                count += 1;
                res += count;
            } else {
                if(count == 0) continue;
                // arr.add(count);
                count = 0;
            }
        }
        // if(count != 0) arr.add(count);

        // long res = 0;
        // for(int c : arr){
        //     res += (long)(c) * (c+1) / 2;
        // }
        return res;
    }
}