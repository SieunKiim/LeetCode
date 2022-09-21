class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        int index = 0;
        HashSet<Integer> evenIndex = new HashSet<>();
        int evenSum = 0;
        int tempIndex =0;
        for(int n : nums){
            if(n%2 == 0) {
                evenIndex.add(tempIndex);
                evenSum += n;
            }
            tempIndex+=1;
        }
        // System.out.println(evenIndex);
        for(int[] q : queries){
            int temp = nums[q[1]] + q[0];
            
            if(temp%2 == 0){
                if(evenIndex.contains(q[1])) evenSum += q[0];
                else {
                    evenSum += temp;
                    evenIndex.add(q[1]);
                }
            }else{
                if(evenIndex.contains(q[1])) evenSum -= nums[q[1]];
                evenIndex.remove((Integer)q[1]);  
            }
            
            result[index] = evenSum;
            nums[q[1]] = temp;
            
            index += 1;
        }
        return result;
    }
}