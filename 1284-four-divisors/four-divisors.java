class Solution {
    public int sumFourDivisors(int[] nums) {
        int output = 0;
        for(int num :nums){
            int temp = 0;
            int index = 1;
            int count = 0;
            while((index * index) < num){
                if(num % index == 0){
                    temp += index;
                    temp += num/index;
                    count += 1;
                }
                index += 1;
            }
            if(count == 2 && index * index != num){
                output += temp;
            }
        }
        return output;
    }
}