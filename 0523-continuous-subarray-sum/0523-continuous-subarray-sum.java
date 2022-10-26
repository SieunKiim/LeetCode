class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer>preSumMod = new HashMap<>();
        preSumMod.put(0,0);
        int presum = 0;
        for(int i =0 ; i< nums.length;i++){
            // System.out.println(preSumMod);
            presum += nums[i];
            int target = presum%k;
            
            
            if(preSumMod.containsKey(target)){
                int index = preSumMod.get(target);
                // System.out.println(index+" "+i);

                if(i-index>=1) return true;
            } else {
                preSumMod.put(target, i+1);
            }
        }
        
        
        
        return false;
    }
}