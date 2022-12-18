class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] output = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<n; i++) {
            int nowTemp = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] < nowTemp){
                int index = stack.pop();
                output[index] = i-index;
            }
            stack.push(i);
        }
        return output;
    }
}