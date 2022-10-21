class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean result = false;
        for(int i =0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                if(Math.abs(map.get(nums[i]) - i) > k) result |= false;
                else result |= true;
                map.put(nums[i], i);
            } else {
                map.put(nums[i],i);
            }

        }
        return result;
    }
}