class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        List<Integer> arr= new ArrayList<>();

        int count = 0;
        for(int i =0 ;i<n;i++){
            if(nums[i] == 1) {
                count += 1;
            } else {
                if(count != 0){
                    arr.add(count);
                    count = 0;
                }
                arr.add(0);
            }
        }
        if(count != 0){
            arr.add(count);
        }

        if(arr.size() == 1){
            return Math.max(0,arr.get(0) -1);
        }

        if(arr.size() == 2){
            return arr.get(0) + arr.get(1);
        }

        int output= 0;
        for(int i=0;i<arr.size()-2;i++){
            output = Math.max(output , arr.get(i)+arr.get(i+1)+arr.get(i+2));
        }
        return output;
    }
}