class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        int last = nums[0];
        int size = 1;
        List<Integer> temp = new ArrayList<>();
        temp.add(last);
        output.add(temp);
        for(int i = 1;i < nums.length ; i++){
            int now = nums[i];
            if(now == last){
                int j;
                for(j = 0 ;j< size; j++){
                    if(!output.get(j).contains(now)){
                        List<Integer> tt = output.get(j);
                        tt.add(now);
                        break;
                    }
                }
                if(j == size){
                    List<Integer> temp2 = new ArrayList<>();
                    temp2.add(now);
                    output.add(temp2);
                    size += 1;
                }
                
            } else {
                List<Integer> tt = output.get(0);
                tt.add(now);
            }
            last = now;
        }
        return output;
    }
}