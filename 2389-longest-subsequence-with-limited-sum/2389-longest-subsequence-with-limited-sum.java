class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        Arrays.sort(nums);
        for(int i = 0; i< n; i++){
            int index = 0;

            int sum = 0;
            while(index < nums.length && sum <= queries[i]){
                sum += nums[index];
                index += 1;
            }
            if(sum > queries[i])
                answer[i] = index-1;
            else
                answer[i] = index;
        }
        return answer;
    }
    
    
}