class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        int zCount1 = 0;
        int zCount2 = 0;
        for(int i =0 ;i< nums1.length; i++){
            sum1 += nums1[i];
            if(nums1[i] == 0) zCount1 += 1;
        }

        for(int i =0 ;i< nums2.length; i++){
            sum2 += nums2[i];
            if(nums2[i] == 0) zCount2 += 1;
        }

        long sumGap = sum1-sum2;
        int zGap = zCount1-zCount2;

        if(((zCount1 == 0 && sumGap + zGap < 0)|| (zCount2 == 0) && sumGap + zGap > 0 )){
            return -1;
        }

        if(sumGap == 0){
            return sum1 + Math.max(zCount1, zCount2);
        }
            
        if(zGap == 0){
            return zCount1 + Math.max(sum1, sum2);
        }

        // if(sumGap * zGap < 0){
            if(sumGap + zGap > 0){
                return sum1 + zCount1;
            }
            return sum2 + zCount2;
        // }
    }
}