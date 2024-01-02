class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int[] count = new int[nums.length + 1];
        for(int num : nums){
            int i = count[num];
            if(count[num] >= output.size()){
                output.add(new ArrayList<>());
            }
            output.get(i).add(num);
            count[num] += 1;
        }
        return output;
    }
}