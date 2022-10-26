class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer>preSumMod = new HashMap<>();
        preSumMod.put(0,0);
        int presum = 0;
        for(int i =0 ; i< nums.length;i++){
            presum += nums[i];
            presum = presum%k;
            if(preSumMod.containsKey(presum)){
                int index = preSumMod.get(presum);
                if(i-index>=1) return true;
            } else {
                preSumMod.put(presum, i+1);
            }
        }
        
        return false;
    }
}