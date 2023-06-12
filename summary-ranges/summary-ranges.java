class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> output = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if(nums.length == 0) return new ArrayList<>();
        for(int num: nums){
            if(stack.isEmpty()){
                stack.push(num);
                continue;
            } 
            
            if( stack.peek() + 1 == num){
                stack.push(num);
            } else {
                int last = stack.peek();
                int first = Integer.MAX_VALUE;
                while(!stack.isEmpty()){
                    first = stack.pop();
                }
                if(first == last){
                    output.add(String.valueOf(last));
                } else {
                    output.add(String.valueOf(first) + "->" + String.valueOf(last));
                }
                stack.push(num);
            }
        }
        int last = stack.peek();
                int first = Integer.MAX_VALUE;
                while(!stack.isEmpty()){
                    first = stack.pop();
                }
                if(first == last){
                    output.add(String.valueOf(last));
                } else {
                    output.add(String.valueOf(first) + "->" + String.valueOf(last));
                }
        return output;
    }
}